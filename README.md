# Sportska Liga - Team & Player Management

## Autori
- Ibrahim Bišić
- Amar Ribo

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
- `/teams/promote/{id}` - Akcija dodavanja pobjede
- `/teams/lose/{id}` - Akcija dodavanja poraza
## Tehnologije
- Spring Boot 3.4.1
- Thymeleaf
- Java 17
- In-memory data storage (bez baze podataka)

Aplikacija će biti dostupna na: `http://localhost:8080`

## Screenshot Aplikacije

### Lista Igrača
<img width="1260" height="858" alt="Igraci" src="https://github.com/user-attachments/assets/27729873-b649-4ee4-8176-f7bc6e21c70e" />

### Lista Timova
<img width="1277" height="860" alt="Timovi" src="https://github.com/user-attachments/assets/d767639d-5ee0-48d7-9c17-412041089c85" />

### Roster Tima (Akcija)
<img width="1277" height="861" alt="Roster" src="https://github.com/user-attachments/assets/3901cb89-29db-4445-b389-55f67e719c23" />

