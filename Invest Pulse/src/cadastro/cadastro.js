document.getElementsByTagName('form').addEventListener('submit', function(event) {
    event.preventDefault();
    window.location.href = '/public/inicial.html';
});