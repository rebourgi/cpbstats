INSERT INTO `type_profil` (`id`, `libelle`) 
VALUES ('1', 'Joueur');

INSERT INTO `cpbstats`.`utilisateur` (`id`, `type_profil_id`, `nom`, `prenom`, `login`, `password`) 
VALUES ('1', '1', 'Rémi', 'Bourgin', 'rebourgi', 'rebourgi');

COMMIT;