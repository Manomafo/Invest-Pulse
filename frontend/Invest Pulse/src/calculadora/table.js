import { info } from "autoprefixer";

const isNonEmptyArray = (arrayElement) => {
  return Array.isArray(arrayElement) && arrayElement.length > 0;
};

export const createTable = (columnsArray, dataArray, tableId) => {
  if (
    !isNonEmptyArray(columnsArray) ||
    !isNonEmptyArray(dataArray) ||
    !tableId
  ) {
    throw new Error(
      "Para a correta execução, presisamos de um array com as colunas, outro com as informações das linhas e tambem o id do elemento tabela selecionado"
    );
  }
  const tableElement = document.getElementById(tableId);
  if (!tableElement || tableElement.nodeName !== "TABLE") {
    throw new Error("ID informado não corresponde a nenhum elemento table");
  }

  createTableHeader(tableElement, columnsArray);
  createTableBody(tableElement, dataArray, columnsArray);
};

function createTableHeader(tableReference, columnsArray) {
  /*  <table>
        <thead></thead>
        <tbody></tbody>
      </table> */
  function createTheadElement(tableHeaderReference) {
    const thaed = document.createElement("thead"); //<thead></thead>
    tableReference.appendChild(thaed); //<table><thead></thead></table>
    return thaed;
  }

  const tableHeaderReference =
    tableReference.querySelector("theade") ??
    createTheadElement(tableReference);
  //<table><thead></thead></table>
  const headerRow = document.createElement("tr"); // <tr></tr>
  ["bg-gray-900", "text-violet-50", "sticky", "top-0"].forEach((cssClass) =>
    headerRow.classList.add(cssClass)
  );
  for (const tableColumnObject of columnsArray) {
    const headerElement = /*html*/ `<th class='text-center' >${tableColumnObject.columnLabel}</th>`;
    headerRow.innerHTML += headerElement;
  }
  //<tr><th class='text-center'>NomeDaColuna</th><th class='text-center'>NomeDaColuna</th></tr>
  tableHeaderReference.appendChild(headerRow);
}
function createTableBody(tableReference, tableItems, columnsArray) {
  function createTbodyElement(tableHeaderReference) {
    const tbody = document.createElement("tbody");
    tableReference.appendChild(tbody);
    return tbody;
  }

  const tableBodyReference =
    tableReference.querySelector("tbody") ?? createTbodyElement(tableReference);

  for (const [itemIndex, tableItem] of tableItems.entries()) {
    const tableRow = document.createElement("tr");
    if (itemIndex % 2 !== 0) {
      tableRow.classList.add("bg-violet-300");
    }
    for (const tableColumn of columnsArray) {
      const formatFn = tableColumn.format ?? ((info) => info);
      tableRow.innerHTML += /*html*/ `<td class='text-center'>${formatFn(
        tableItem[tableColumn.accessor]
      )}</td>`;
    }
    tableBodyReference.appendChild(tableRow);
  }
}
