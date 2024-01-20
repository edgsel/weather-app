# Weather web app

## What:

Web app to show weather based on current location

### **Weather API client**

Stack:

- Weather app BE:
    - Spring boot 3
    - Websocket
    - Kotlin
    - Redis for caching weather data
    - Quartz cron for keep weather data up to date
- Weather app FE:
    - Angular (bc used in LHV), need to learn it

### **MVP:**

- Get weather data by current location (**Geolocation API)**
- Get weather data by city
- Fetch weather data by cron job
- 