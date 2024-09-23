const ctx = document.getElementById('chart').getContext('2d');
const hamburger = document.getElementById('hamburger');
const navLinks = document.getElementById('nav-links');

let chart = new Chart(ctx, {
    type: 'line',
    data: {
        labels: ['06/08/2024', '07/08/2024', '08/08/2024', '09/08/2024', '12/08/2024', '13/08/2024', '14/08/2024', '15/08/2024', '16/08/2024', '19/08/2024', '20/08/2024', '21/08/2024', '22/08/2024', '23/08/2024', '26/08/2024', '27/08/2024', '28/08/2024', '29/08/2024', '30/08/2024', '02/09/2024', '03/09/2024', '04/09/2024', '05/09/2024'],
        datasets: [{
            label:"Ibovespa",
            fill: true,
            lineTension:0,
            // backgroundColor:"rgba(0,0,0,0.5)",
            backgroundColor:"rgba(0,0,0,0.5)",
            // borderColor:"rgba(255,210,0,1)",
            borderColor:"#007bff",
            borderCapStyle:"butt",
            borderDash: [],
            borderDashOffset:0.0,
            borderJoinStyle:"miter",
            pointBorderColor:"rgba(75,192,192,1)",
            pointBackgroundColor:"#fff",
            pointBorderWidth:"1",
            pointHoverRadius:"3",
            pointHoverBackgroundColor:"rgba(75,192,192,1)",
            pointHoverBorderColor:"rgba(220,220,220,1)",
            pointHoverBorderWidth:"2",
            pointRadius:"1",
            pointHitRadius:"10",
            data: [126266.70, 127513.88, 128660.88, 130614.59, 131115.90, 132397.97, 133317.66, 134153.42, 133953.25, 135777.98, 136087.41, 136463.65, 135173.39, 135608.47, 136888.71, 136775.91, 137343.96, 136041.35, 136004.01, 134906.07, 134353.48, 136110.73, 136502.49],
            // fill:true,
            // backgroundColor: "#ccc",
            // label: 'Gráfico 1',
            // data: [5410, 10665, 21430, 35040, 40124, 58798, 62205, 74872],
            // backgroundColor: 'rgba(0, 123, 255, 0.5)',
            // borderColor: '#007bff',
            // borderWidth: 1
        }]
    }
});

document.getElementById('Ibovespa').addEventListener('click', () => {
    updateChart([126266.70, 127513.88, 128660.88, 130614.59, 131115.90, 132397.97, 133317.66, 134153.42, 133953.25, 135777.98, 136087.41, 136463.65, 135173.39, 135608.47, 136888.71, 136775.91, 137343.96, 136041.35, 136004.01, 134906.07, 134353.48, 136110.73, 136502.49], 'Ibovespa');
});
document.getElementById('CPLE3').addEventListener('click', () => {
    updateChart([9.19, 9.15, 9.15, 9.29, 9.32, 9.36, 9.53, 9.44, 9.45, 9.56, 9.56, 9.55, 9.53, 9.66, 9.54, 9.44, 9.49, 9.45, 9.38, 9.49, 9.57, 9.76, 9.76], 'CPLE3');
});

document.getElementById('BBAS3').addEventListener('click', () => {
    updateChart([26.26, 25.91, 25.80, 26.16, 26.72, 27.06, 27.52, 27.73, 27.95, 28.70, 28.83, 28.70, 28.01, 28.22, 28.33, 28.01, 28.18, 28.30, 28.12, 28.42, 28.68, 28.99, 29.25], 'BBAS3');
});

document.getElementById('IFRA11').addEventListener('click', () => {
    updateChart([107.43, 107.09, 107.99, 107.76, 107.95, 108.06, 108.79, 108.46, 109.52, 109.24, 109.34, 109.42, 109.23, 109.92, 109.18, 109.56, 109.24, 109.42, 109.92, 110.31, 110.43, 111.20, 108.51], 'IFRA11');
});

document.getElementById('LFTS11').addEventListener('click', () => {
    updateChart([122.18, 122.24, 122.28, 122.35, 122.38, 122.42, 122.48, 122.53, 122.57, 122.60, 122.66, 122.71, 122.77, 122.81, 122.87, 122.92, 122.95, 123.00, 123.07, 123.12, 123.15, 123.22, 123.27], 'LFTS11');
});

function updateChart(data, label) {
    chart.data.datasets[0].data = data;
    chart.data.datasets[0].label = label;
    chart.update();
}

hamburger.addEventListener('click', () => {
    navLinks.classList.toggle('active');
});
