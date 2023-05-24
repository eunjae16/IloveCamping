const toggleBtn = document.querySelector('.navbar-toggleBtn');
const menu = document.querySelector('.side-menu');

toggleBtn.addEventListener('click', () => {
    menu.classList.toggle('active');
});