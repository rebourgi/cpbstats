INSERT INTO `type_profil` (`id`, `libelle`) 
VALUES ('1', 'Joueur');

INSERT INTO `cpbstats`.`utilisateur` (`id`, `type_profil_id`, `nom`, `prenom`, `login`, `password`) 
VALUES ('1', '1', 'Rémi', 'Bourgin', 'rebourgi', 'rebourgi');

INSERT INTO `cpbstats`.`utilisateur` (`id`, `type_profil_id`, `nom`, `prenom`, `login`, `password`) 
VALUES ('2', '1', 'Gael', 'Routié', 'groutie', 'groutie');

INSERT INTO `cpbstats`.`type_exercice` (`libelle`, `unite`, `format`, `description`) 
VALUES ('Pompes', 'pompes', '([1-9])+', 'Nombre de pompes effectuées');

INSERT INTO `cpbstats`.`type_exercice` (`libelle`, `unite`, `format`, `description`) 
VALUES ('Course', 'minutes', '([1-9])+', 'Temps de course');

INSERT INTO `cpbstats`.`type_exercice` (`libelle`, `unite`, `format`, `description`) 
VALUES ('Abdominos', 'abdominos', '([1-9])+', 'Nombre d''abdominos effectués');

COMMIT;