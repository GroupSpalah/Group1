USE notepads;

CREATE TABLE notebooks (
  manufacturer_name VARCHAR(50) NOT NULL,
  notebook_name VARCHAR(50) NOT NULL,
  number_of_pages INT CHECK (number_of_pages > 0),
  cover_type SET('hard', 'soft') NOT NULL,
  country_of_origin VARCHAR(50) NOT NULL,
  appearance_of_the_notebook_page SET('square', 'ruler', 'empty') NOT NULL
);

INSERT INTO notebooks VALUES
('Moleskine', 'Classic Notebook', 240, 'hard', 'Italy', 'ruler'),
('Leuchtturm1917', 'Medium A5 Notebook', 249, 'hard', 'Germany', 'square'),
('Rhodia', 'Webnotebook', 192, 'hard', 'France', 'square'),
('Field Notes', 'Original Kraft Notebook', 48, 'soft', 'USA', 'ruler'),
('Midori', 'MD Notebook', 176, 'soft', 'Japan', 'empty'),
('Mnemosyne', 'Inspiration Notebook', 70, 'soft', 'Japan', 'square'),
('Clairefontaine', 'Age Bag Notebook', 192, 'soft', 'France', 'ruler'),
('Rite in the Rain', 'All-Weather Notebook', 100, 'soft', 'USA', 'ruler'),
('Paperblanks', 'Lindau Gospel Notebook', 144, 'hard', 'Canada', 'square'),
('Miquelrius', 'Flexible Notebook', 300, 'soft', 'Spain', 'ruler'),
('Dingbats', 'Wildlife Medium A5+ Notebook', 192, 'hard', 'Lebanon', 'square'),
('Baron Fig', 'Confidant Notebook', 192, 'hard', 'USA', 'empty'),
('Lamy', 'Notebook Medium A5', 192, 'hard', 'Germany ', 'square'),
('Stalogy', 'Editor\'s Series 365Days Notebook', 368, 'soft', 'Japan', 'empty'),
('Papier', 'Personalised Notebook', 160, 'soft', 'UK', 'ruler'),
('Scribbles That Matter', 'Iconic Version Dotted Journal', 201, 'hard', 'UK', 'square'),
('Archer & Olive', 'Blackout Book', 160, 'hard', 'USA', 'square'),
('Hobonichi Techo ', 'Planner Book ', 448, 'hard', 'Japan', 'empty'),
('Traveler\'s Company', 'Traveler\'s Notebook Refill ', 64, 'soft', 'Japan', 'ruler'),
('Moleskine', 'Smart Writing Set Ellipse', 176, 'hard', 'Italy', 'ruler');