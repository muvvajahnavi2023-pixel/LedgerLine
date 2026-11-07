# LedgerLine - AI Prompts & Engineering Log

## Date: November 6, 2026
* **Commit Link:** Initial commit
* **What I Asked:** Asked AI for project structure and initial setup guidelines for LedgerLine backend.
* **What the AI Produced:** Suggested a basic folder structure with standard configuration files.
* **What Was Wrong / Risk:** The AI structure lacked explicit separation for security configs and double-entry validation layers.
* **What I Did Instead:** Organized the package structure into dedicated packages (`model`, `repository`, `service`, `controller`, `config`) to maintain clean architecture.

Date: November 7, 2026

* **Commit Link:** `feat: add User, Account, Transaction, and LedgerEntry domain entities`
* **What I Asked:** Asked AI to model domain entities (`User`, `Account`, `Transaction`, `LedgerEntry`) for a double-entry ledger system.
* **What the AI Produced:** Generated basic JPA entity classes for money transfer models.
* **What Was Wrong / Risk:** Floating-point numbers (`double`/`float`) lead to precision loss and rounding errors in financial transactions.
* **What I Did Instead:** Used `BigDecimal` with `@Column(precision = 19, scale = 4)` for exact financial accuracy, added unique idempotency keys in `Transaction`, and enforced double-entry `DEBIT`/`CREDIT` audit tracking.
*