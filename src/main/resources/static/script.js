// Tab switching functionality
document.addEventListener('DOMContentLoaded', function() {
    const tabButtons = document.querySelectorAll('.tab-btn');
    const bookingContents = document.querySelectorAll('.booking-content');

    tabButtons.forEach(button => {
        button.addEventListener('click', function() {
            const targetTab = this.getAttribute('data-tab');

            // Remove active class from all tabs and contents
            tabButtons.forEach(btn => btn.classList.remove('active'));
            bookingContents.forEach(content => content.classList.remove('active'));

            // Add active class to clicked tab and corresponding content
            this.classList.add('active');
            document.getElementById(targetTab + '-content').classList.add('active');
        });
    });

    // Mobile menu toggle
    const mobileMenuToggle = document.querySelector('.mobile-menu-toggle');
    const navMenu = document.querySelector('.nav-menu');
    const navButtons = document.querySelector('.nav-buttons');

    if (mobileMenuToggle) {
        mobileMenuToggle.addEventListener('click', function() {
            navMenu.classList.toggle('active');
            navButtons.classList.toggle('active');
            this.classList.toggle('active');
        });
    }

    // Smooth scrolling for anchor links
    document.querySelectorAll('a[href^="#"]').forEach(anchor => {
        anchor.addEventListener('click', function(e) {
            const href = this.getAttribute('href');
            if (href !== '#' && href !== '') {
                e.preventDefault();
                const target = document.querySelector(href);
                if (target) {
                    const offsetTop = target.offsetTop - 72; // Account for fixed navbar
                    window.scrollTo({
                        top: offsetTop,
                        behavior: 'smooth'
                    });
                }
            }
        });
    });

    // Form submission handler (prevent default for demo)
    const bookingForm = document.querySelector('.booking-form');
    if (bookingForm) {
        bookingForm.addEventListener('submit', function(e) {
            e.preventDefault();

            const pickupInput = this.querySelector('input[placeholder*="pickup"]');
            const destinationInput = this.querySelector('input[placeholder*="destination"]');

            if (pickupInput.value && destinationInput.value) {
                alert('Ride requested from ' + pickupInput.value + ' to ' + destinationInput.value + '!\n\nThis is a demo. In a real app, this would process your ride request.');
                pickupInput.value = '';
                destinationInput.value = '';
            } else {
                alert('Please enter both pickup and destination locations.');
            }
        });
    }

    // Navbar background change on scroll
    const navbar = document.querySelector('.navbar');
    let lastScroll = 0;

    window.addEventListener('scroll', function() {
        const currentScroll = window.pageYOffset;

        if (currentScroll > 10) {
            navbar.style.boxShadow = '0 2px 8px rgba(0, 0, 0, 0.1)';
        } else {
            navbar.style.boxShadow = '0 1px 3px rgba(0, 0, 0, 0.1)';
        }

        lastScroll = currentScroll;
    });

    // Intersection Observer for fade-in animations
    const observerOptions = {
        threshold: 0.1,
        rootMargin: '0px 0px -50px 0px'
    };

    const observer = new IntersectionObserver(function(entries) {
        entries.forEach(entry => {
            if (entry.isIntersecting) {
                entry.target.style.opacity = '1';
                entry.target.style.transform = 'translateY(0)';
            }
        });
    }, observerOptions);

    // Add animation styles and observe elements
    const animatedElements = document.querySelectorAll('.suggestion-card, .feature-item');
    animatedElements.forEach(el => {
        el.style.opacity = '0';
        el.style.transform = 'translateY(20px)';
        el.style.transition = 'opacity 0.6s ease, transform 0.6s ease';
        observer.observe(el);
    });

    // Get Started button handlers
    const getStartedButtons = document.querySelectorAll('.btn-feature, .btn-submit');
    getStartedButtons.forEach(button => {
        if (button.textContent.includes('Get started')) {
            button.addEventListener('click', function(e) {
                if (this.tagName !== 'BUTTON' || this.type !== 'submit') {
                    e.preventDefault();
                    alert('Welcome to RideShare!\n\nThis would take you to the sign-up page. In a real application, you would create an account and start driving or riding.');
                }
            });
        }
    });

    // App download button handlers
    const appButtons = document.querySelectorAll('.app-btn');
    appButtons.forEach(button => {
        button.addEventListener('click', function(e) {
            e.preventDefault();
            const store = this.textContent.includes('App Store') ? 'App Store' : 'Google Play';
            alert('Redirecting to ' + store + '...\n\nIn a real application, this would open the respective app store.');
        });
    });
});
