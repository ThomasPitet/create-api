-- Insertion de donnees de test au demarrage de l'application
INSERT INTO
    produits (nom, description, prix, stock)
VALUES (
        'Clavier mecanique',
        'Clavier gaming RGB avec switches Cherry MX',
        89.99,
        50
    ),
    (
        'Souris ergonomique',
        'Souris sans fil avec support poignet',
        45.50,
        120
    ),
    (
        'Ecran 27 pouces',
        'Moniteur IPS 4K pour developpeurs',
        349.00,
        25
    ),
    (
        'Casque audio',
        'Casque Bluetooth avec reduction de bruit',
        129.99,
        75
    ),
    (
        'Hub USB-C',
        'Hub 7 ports avec HDMI et lecteur SD',
        39.99,
        200
    ),
    (
        'Webcam HD',
        'Webcam 1080p avec micro integre',
        59.99,
        90
    ),
    (
        'Tapis de souris XXL',
        'Tapis gaming 80x30cm antiderapant',
        19.99,
        300
    ),
    (
        'Support laptop',
        'Support reglable en aluminium',
        34.99,
        60
    );

INSERT INTO
    users (nom, prenom, email, age)
VALUES (
        'Dupont',
        'Jean',
        'jean.dupont@example.com',
        25
    ),
    (
        'Martin',
        'Sophie',
        'sophie.martin@example.com',
        30
    ),
    (
        'Bernard',
        'Lucas',
        'lucas.bernard@example.com',
        22
    ),
    (
        'Petit',
        'Emma',
        'emma.petit@example.com',
        28
    ),
    (
        'Robert',
        'Thomas',
        'thomas.robert@example.com',
        35
    ),
    (
        'Richard',
        'Léa',
        'lea.richard@example.com',
        24
    ),
    (
        'Durand',
        'Hugo',
        'hugo.durand@example.com',
        40
    ),
    (
        'Moreau',
        'Camille',
        'camille.moreau@example.com',
        27
    );