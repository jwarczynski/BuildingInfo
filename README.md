# BuildingInfo
A project for a software engineering class

# Build to jar command
```mvn clean package```


# Project Description
Dla administratorów budynków, którzy pragną optymalizować koszty zarządzania budynkami  nasza aplikacja Building Info umożliwi pozyskanie informacji o parametrach budynku na poziomie pomieszczeń, kondygnacji oraz całych budynków. Aplikacja będzie dostępna poprzez GUI a także jako zdalne API dzięki czemu można ją zintegrować z istniejącymi narzędziami.

# Data structure
- Lokacja to budynek, poziom, lub pomieszczenie
- Budynek może składać się z poziomów a te z pomieszczeń
- Każda lokalizacja jest charakteryzowana przez:
    - id – unikalny identyfikator
   - name – opcjonalna nazwa lokalizacji
- Pomieszczenie dodatkowo jest charakteryzowane przez:
   - area = powierzchnia w m^2
   - cube = kubatura pomieszczenia w m^3
   - heating = poziom zużycia energii ogrzewania (float)
   - light – łączna moc oświetlenia
