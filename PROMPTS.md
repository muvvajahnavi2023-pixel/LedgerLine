# LedgerLine - AI Prompts & Engineering Log

## Date: November 6, 2026
* **Commit Link:** Initial commit
* **What I Asked:** Asked AI for project structure and initial setup guidelines for LedgerLine backend.
* **What the AI Produced:** Suggested a basic folder structure with standard configuration files.
* **What Was Wrong / Risk:** The AI structure lacked explicit separation for security configs and double-entry validation layers.
* **What I Did Instead:** Organized the package structure into dedicated packages (`model`, `repository`, `service`, `controller`, `config`) to maintain clean architecture.

Date: November 7, 2026

* **Commit Link:** `feat: add User, Account, Transaction, and LedgerEntry domain entities`
* **What I Asked:** Asked AI to design core domain entities (User, Account, Transaction, LedgerEntry) for money transfers.
* **What the AI Produced:** Generated basic entity classes for standard transaction models.
* **What Was Wrong / Risk:** Normal decimal numbers can lose accuracy and cause money rounding mistakes during calculations.
* **What I Did Instead:** Enforced exact financial precision for balances, added transaction reference keys to stop duplicate payments, and tracked debit and credit entries separately for audit safety.

Date: November 8, 2026

* **Commit Link:** `feat: add Spring Data JPA repositories with pessimistic locking`
* **What I Asked:** Asked AI to design repository interfaces for database access across all entities.
* **What the AI Produced:** Generated basic JpaRepository interfaces.
* **What Was Wrong / Risk:** Standard database reads allow concurrent transactions to read stale balances, leading to double spending.
* **What I Did Instead:** Added `findByIdWithLock` in `AccountRepository` with pessimistic write locking (`FOR UPDATE`) to lock account rows during transfers.

Date: November 9, 2026

* **Commit Link:** `feat: add LedgerController and DTOs for money transfer API`
* **What I Asked:** Asked AI to expose HTTP endpoints for performing money transfers between accounts.
* **What the AI Produced:** Generated a basic REST controller accepting transfer payloads.
* **What Was Wrong / Risk:** Uncontrolled endpoint input can cause runtime exceptions or improper HTTP responses during invalid transfers.
* **What I Did Instead:** Created explicit TransferRequest DTOs and wrapped endpoint calls in structured HTTP response handlers with proper error catching.

Date: November 10, 2026

* **Commit Link:** `feat: create frontend UI dashboard for ledger transfers`
* **What I Asked:** Asked AI to design a frontend user interface to interact with the backend transfer API.
* **What the AI Produced:** Generated an HTML/JS template for submitting money transfers.
* **What Was Wrong / Risk:** Unvalidated frontend inputs or raw error exposures could degrade UX or obscure API error responses.
* **What I Did Instead:** Built a clean interactive form capturing explicit source/target accounts, amounts, and idempotency references with structured feedback alerts.