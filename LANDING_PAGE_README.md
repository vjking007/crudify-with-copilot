# Uber-Style Landing Page

## Overview
I've created an Uber-style landing page for your ride service application. The landing page is fully responsive and includes modern design elements inspired by Uber.

## Location
The landing page files are located at:
```
src/main/resources/static/
├── index.html    (Main HTML structure)
├── styles.css    (Uber-inspired styling)
└── script.js     (Interactive features)
```

## Features

### 1. **Hero Section**
- Eye-catching gradient background (purple theme)
- Interactive booking form with two tabs:
  - **Ride**: Request a ride with pickup and destination inputs
  - **Drive**: Information for drivers to get started

### 2. **Navigation Bar**
- Fixed navigation with smooth scrolling
- Logo branding ("RideShare")
- Menu items: Ride, Drive, About, Help
- Login and Sign up buttons
- Mobile-responsive with hamburger menu

### 3. **Suggestions Section**
- Three service cards:
  - Ride
  - Reserve
  - Travel Intercity
- Hover animations for better UX

### 4. **Features Section**
- Three main feature highlights:
  - **Drive when you want**: Driver recruitment
  - **RideShare for Business**: Business solutions
  - **Your safety drives us**: Safety features
- Alternating layout with gradient backgrounds
- Call-to-action buttons

### 5. **App Download Section**
- App Store and Google Play download buttons
- Clean, centered design

### 6. **Footer**
- Multi-column layout with links:
  - Company
  - Products
  - Global citizenship
  - Travel
- Social media icons
- Legal links and copyright

## How to Access

### Option 1: Run Spring Boot Application
1. Make sure Java 17 is installed
2. Build and run the application:
   ```bash
   ./mvnw spring-boot:run
   ```
3. Open your browser and navigate to:
   ```
   http://localhost:8080/
   ```

### Option 2: Open Directly in Browser (Development)
Since these are static files, you can also open them directly:
1. Navigate to `src/main/resources/static/`
2. Open `index.html` in your browser

### Option 3: Use a Simple HTTP Server
```bash
cd src/main/resources/static/
python3 -m http.server 8080
# or
npx serve .
```

Then visit: `http://localhost:8080`

## Interactive Features

### JavaScript Functionality:
- **Tab Switching**: Toggle between "Ride" and "Drive" booking forms
- **Smooth Scrolling**: Click navigation links for smooth page scrolling
- **Form Handling**: Demo ride request form with validation
- **Scroll Effects**: Navbar shadow changes on scroll
- **Fade-in Animations**: Content fades in as you scroll
- **Mobile Menu**: Responsive hamburger menu for mobile devices

## Responsive Design
The landing page is fully responsive and works on:
- Desktop (1200px+)
- Tablet (768px - 1024px)
- Mobile (320px - 768px)

## Color Scheme
- **Primary Gradient**: Purple/Violet (#667eea to #764ba2)
- **Secondary Colors**:
  - Pink gradient (#f093fb to #f5576c)
  - Blue gradient (#4facfe to #00f2fe)
- **Neutrals**: Black, white, and various grays

## Customization
To customize the landing page:

1. **Change Brand Name**: Edit "RideShare" in `index.html`
2. **Modify Colors**: Update gradient values in `styles.css`
3. **Add Real Images**: Replace `.feature-placeholder` backgrounds with actual images
4. **Connect to Backend**: Update form submission in `script.js` to call your API endpoints
5. **Update Links**: Replace "#" href values with actual routes

## Integration with Your Backend
The landing page can be integrated with your Spring Boot backend:
- Form submissions can POST to `/api/rides` (create this endpoint)
- User authentication can be integrated with your auth system
- Driver signup can POST to `/api/drivers`

## Next Steps
1. Run the Spring Boot application
2. Access the landing page at `http://localhost:8080/`
3. Customize branding and colors
4. Add real images
5. Connect form submissions to your backend API
6. Add user authentication
7. Deploy to production

Enjoy your new Uber-style landing page!
