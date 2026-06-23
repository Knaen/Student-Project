// Sidebar menyularının aktivliyini idarə edən sadə frontend skripti
document.querySelectorAll('.sidebar-menu li a').forEach(menuLink => {
    menuLink.addEventListener('click', function(e) {
        // Əvvəlki aktiv elementi təmizləyirik
        document.querySelector('.sidebar-menu li a.active').classList.remove('active');
        // Kliklənən menyunu aktiv edirik
        this.classList.add('active');
    });
});

console.log("🎓 Student Dashboard Frontend System Initialized Successfully.");