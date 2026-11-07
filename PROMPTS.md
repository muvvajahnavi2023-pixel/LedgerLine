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
