# Sportska Liga - Team, Player & Coach Management

## Lab Vježba 2 - Nadogradnja REST API i Baze Podataka

## Autori
- Ibrahim Bišić
- Amar Ribo

## Opis Aplikacije
Mini MVC Spring Boot aplikacija za upravljanje sportskom ligom sa timovima, igračima i trenerima. Aplikacija je nadograđena sa MySQL bazom podataka, REST API endpoint-ima i novim Coach modelom.

## Modeli i Relacije

### Model A: Team (Tim)
- **Atributi:**
    - `id` - jedinstveni identifikator (Long)
    - `name` - naziv tima (String)
    - `city` - grad (String)
    - `founded` - godina osnivanja (String)
    - `stadium` - naziv stadiona (String)
    - `players` - lista igrača (relacija One-to-Many)
    - `coach` - trener tima (relacija Many-to-One)

### Model B: Player (Igrač)
- **Atributi:**
    - `id` - jedinstveni identifikator (Long)
    - `name` - ime igrača (String)
    - `position` - pozicija (String)
    - `jerseyNumber` - broj dresa (Integer)
    - `team` - tim kojem pripada (relacija Many-to-One)

### Model C: Coach (Trener) - NOVI MODEL
- **Atributi:**
    - `id` - jedinstveni identifikator (Long)
    - `name` - ime trenera (String)
    - `nationality` - nacionalnost (String)
    - `experienceYears` - godine iskustva (Integer)
    - `teams` - lista timova koje trenira (relacija One-to-Many)

### Relacije

#### Team ↔ Player (One-to-Many)
Jedan tim ima više igrača. Svaki igrač pripada jednom timu.
- **Kardinalnost:** 1:N
- **Implementacija:** `@OneToMany` u Team modelu, `@ManyToOne` u Player modelu

#### Coach ↔ Team (One-to-Many)
Jedan trener može trenirati više timova. Svaki tim ima jednog trenera.
- **Kardinalnost:** 1:N
- **Implementacija:** `@OneToMany` u Coach modelu, `@ManyToOne` u Team modelu
- **Logika:** Omogućava praćenje karijere trenera kroz više timova i dodjeljivanje trenera timovima

## Controlleri

### MainController (MVC Controller)
Obični Spring MVC controller koji koristi Thymeleaf za prikaz HTML stranica.

**Funkcionalnosti:**
- **GET `/teams`** - Prikazuje listu svih timova
- **GET `/players`** - Prikazuje listu svih igrača
- **GET `/roster/{id}`** - Prikazuje roster tima sa detaljima igrača
- **GET `/coaches`** - Prikazuje listu svih trenera
- **GET `/coaches/new`** - Prikazuje formu za dodavanje novog trenera
- **POST `/coaches`** - Procesira dodavanje novog trenera u bazu
- **GET `/coaches/edit/{id}`** - Prikazuje formu za izmjenu trenera sa postojećim podacima
- **POST `/coaches/update/{id}`** - Procesira izmjene i ažurira trenera u bazi

**Thymeleaf Integracija:**
- Koristi `coaches.html` template za prikaz liste trenera i forme
- Podržava dodavanje i izmjenu objekata kroz HTML forme
- Automatsko povezivanje podataka sa `th:object`, `th:field` i `th:action`

### CoachRestController (REST API Controller)
REST controller koji vraća podatke u JSON formatu za API integracije.

**Funkcionalnosti:**
- **GET `/api/coaches`** - Vraća sve trenere (JSON Array)
- **GET `/api/coaches/{id}`** - Vraća trenera po ID-u (JSON Object)
- **GET `/api/coaches/nationality/{nationality}`** - Vraća trenere po nacionalnosti (JSON Array)
- **POST `/api/coaches`** - Kreira novog trenera (prima JSON, vraća JSON)
- **PUT `/api/coaches/{id}`** - Ažurira postojećeg trenera (prima JSON, vraća JSON)
- **DELETE `/api/coaches/{id}`** - Briše trenera (vraća status 204 No Content)

**JSON Primjeri:**

GET `/api/coaches`:
\`\`\`json
[
{
"id": 1,
"name": "Pep Guardiola",
"nationality": "Španija",
"experienceYears": 15,
"teams": []
}
]
\`\`\`

POST `/api/coaches` (Request Body):
\`\`\`json
{
"name": "Novi Trener",
"nationality": "Bosna i Hercegovina",
"experienceYears": 5
}
\`\`\`

## Arhitektura Aplikacije

### Slojevi (Layers)
\`\`\`
Controller Layer → Service Layer → Repository Layer → Database
\`\`\`

1. **Controller Layer**: `MainController`, `CoachRestController`
2. **Service Layer**: `TeamService`, `PlayerService`, `CoachService`
3. **Repository Layer**: `TeamRepository`, `PlayerRepository`, `CoachRepository` (Spring Data JPA)
4. **Database**: MySQL relaciona baza podataka

## Konfiguracija Baze Podataka

### MySQL Setup

**application.properties:**
```properties
# MySQL connection settings
spring.datasource.url=jdbc:mysql://localhost:3306/sportsleague?allowPublicKeyRetrieval=true&useSSL=false
spring.datasource.username=root
spring.datasource.password=root
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

# JPA/Hibernate settings
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
spring.jpa.properties.hibernate.format_sql=true
