# Sportska Liga - Team & Player Management

## Autori
- Student A - Kreirao Team model, rute i view lista timova
- Student B - Kreirao Player model, rute i view lista igrača
- A + B zajednički - Akcija promocije tima i roster stranica

## Opis Aplikacije
Mini MVC Spring Boot aplikacija za upravljanje sportskom ligom sa timovima i igračima.

## Modeli i Relacija

### Model A: Team (Tim)
- **Atributi:**
  - `id` - jedinstveni identifikator
  - `name` - naziv tima
  - `city` - grad
  - `founded` - godina osnivanja
  - `stadium` - naziv stadiona
  - `wins` - broj pobjeda
  - `losses` - broj poraza
  - `players` - lista igrača (relacija 1:N)

### Model B: Player (Igrač)
- **Atributi:**
  - `id` - jedinstveni identifikator
  - `name` - ime igrača
  - `position` - pozicija (Napadač, Vezni, Odbrana, Golman)
  - `jerseyNumber` - broj dresa
  - `age` - godine
  - `teamId` - ID tima kojem pripada

### Relacija: 1:N (One-to-Many)
Jedan tim ima više igrača. Svaki igrač pripada jednom timu.

## Rute

### GET Rute
- `/` - Redirect na `/teams`
- `/teams` - Lista svih timova
- `/players` - Lista svih igrača
- `/teams/roster/{id}` - Prikaz roster-a tima sa detaljima

### POST Rute
- `/teams/promote/{id}` - Akcija promocije tima (dodaje +1 pobjedu)

## Tehnologije
- Spring Boot 3.4.1
- Thymeleaf
- Java 17
- In-memory data storage (bez baze podataka)

## Pokretanje
\`\`\`bash
./mvnw spring-boot:run
\`\`\`

Aplikacija će biti dostupna na: `http://localhost:8080`

## Screenshot Aplikacije

### Lista Timova
![Teams List](screenshot-teams.png)

### Lista Igrača
![Players List](screenshot-players.png)

### Roster Tima (Akcija)
![Team Roster](screenshot-roster.png)
