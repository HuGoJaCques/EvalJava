-- Insérer des données dans la table Entreprise
INSERT INTO Entreprise (nom) VALUES ('Entreprise A');
INSERT INTO Entreprise (nom) VALUES ('Entreprise B');

-- Insérer des données dans la table Utilisateur
INSERT INTO Utilisateur (email, password,entreprise_id) VALUES ('admin@example.com', 'admin_password',NULL);
INSERT INTO Utilisateur (email, password,entreprise_id) VALUES ('entrepriseA@example.com', 'entrepriseA_password', 1);
INSERT INTO Utilisateur (email, password,entreprise_id) VALUES ('entrepriseB@example.com', 'entrepriseB_password', 2);

-- Insérer des données dans la table Convention
INSERT INTO Convention (nom, subvention, salarie_maximum, entreprise_id) VALUES ('Convention 1', 1000.0, 5, 1);
INSERT INTO Convention (nom, subvention, salarie_maximum, entreprise_id) VALUES ('Convention 2', 1500.0, 10, 1);
INSERT INTO Convention (nom, subvention, salarie_maximum, entreprise_id) VALUES ('Convention 3', 2000.0, 3, 2);

-- Insérer des données dans la table Salarie
INSERT INTO Salarie (matricule, code_barre, convention_id) VALUES ('SAL001', '123456789', 1);
INSERT INTO Salarie (matricule, code_barre, convention_id) VALUES ('SAL002', '987654321', 1);
INSERT INTO Salarie (matricule, code_barre, convention_id) VALUES ('SAL003', '111223344', 2);
INSERT INTO Salarie (matricule, code_barre, convention_id) VALUES ('SAL004', '443322111', 3);
