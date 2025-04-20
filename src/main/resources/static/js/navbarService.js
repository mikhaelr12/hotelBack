document.addEventListener('DOMContentLoaded', () => {
    const token = localStorage.getItem('token');
    const navLinksUl = document.querySelector('#nav-links ul');

    if (token) {
        navLinksUl.innerHTML = `
          <li><a href="/index">Home</a></li>
          <li><a href="/hotels">Hotels</a></li>
          <li><a href="/my-bookings">My Bookings</a></li>
          <li><a href="/index" id="logout-btn">Log Out</a></li>
        `;
        document.getElementById('logout-btn').addEventListener('click', (e) => {
            e.preventDefault();
            localStorage.removeItem('token');
            localStorage.removeItem('user');
            localStorage.removeItem('expiresIn');
            localStorage.removeItem('returnUrl');
            window.location.href = '/index';
        });
    } else {
        navLinksUl.innerHTML = `
          <li><a href="/index">Home</a></li>
          <li><a href="/hotels">Hotels</a></li>
          <li><a href="/login">Log In</a></li>
          <li><a href="/signup">Sign Up</a></li> 
        `;
    }
});