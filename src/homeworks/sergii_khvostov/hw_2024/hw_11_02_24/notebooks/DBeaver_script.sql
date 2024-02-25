CREATE DATABASE notebooks;
USE notebooks;

CREATE TABLE notebooks (
id int AUTO_INCREMENT PRIMARY KEY,
manufacturer varchar(100),
notebook_name varchar(50),
page_count int,
cover_type varchar(30),
country varchar(50),
page_appearance varchar(20)
);

INSERT INTO notebooks (manufacturer, notebook_name, page_count, cover_type, country, page_appearance)
VALUES
('Nike', 'AirMax', 100, 'hard', 'USA', 'lined'),
('Adidas', 'UltraBoost', 150, 'soft', 'Germany', 'grid'),
('BookMark', 'EpicBook', 120, 'hard', 'UK', 'blank'),
('TechNote', 'QuantumPad', 80, 'soft', 'Japan', 'dotted'),
('GlobalGadget', 'SmartPad', 200, 'hard', 'China', 'lined'),
('FashionStationery', 'ChicBook', 120, 'soft', 'France', 'grid'),
('InnoTech', 'TechJot', 96, 'hard', 'South Korea', 'blank'),
('EcoNote', 'GreenLeaf', 150, 'soft', 'Canada', 'lined'),
('Traveler', 'Wanderlust', 80, 'hard', 'Australia', 'dotted'),
('Imagineering', 'DreamBook', 120, 'soft', 'Brazil', 'grid'),
('ArtisanCraft', 'HandmadeDiary', 96, 'hard', 'Italy', 'blank'),
('Papyrus', 'AncientScroll', 100, 'soft', 'Egypt', 'lined'),
('SummitTech', 'SummitPad', 150, 'hard', 'Switzerland', 'dotted'),
('PolarNote', 'ArcticJournal', 80, 'soft', 'Norway', 'grid'),
('TropicalCraft', 'IslandSketch', 120, 'hard', 'Jamaica', 'blank'),
('Zenith', 'EtherealNote', 96, 'soft', 'India', 'lined'),
('NordicInk', 'VikingSaga', 80, 'hard', 'Sweden', 'dotted'),
('AlpineArt', 'MountainCanvas', 150, 'soft', 'Austria', 'grid'),
('GlobeTrotter', 'NomadLog', 120, 'hard', 'New Zealand', 'blank'),
('TechCraft', 'FutureScript', 96, 'soft', 'Singapore', 'lined'),
('SkylineDesign', 'CityScape', 150, 'hard', 'Russia', 'dotted'),
('CharmNote', 'CherryBlossom', 120, 'soft', 'South Korea', 'grid'),
('MysticInk', 'EnchantedScript', 96, 'hard', 'Ireland', 'blank'),
('BorealTales', 'NorthernChronicle', 80, 'soft', 'Canada', 'lined'),
('ExoticWonders', 'SafariSketch', 120, 'hard', 'Kenya', 'dotted'),
('SilkRoadCraft', 'NomadTales', 96, 'soft', 'Uzbekistan', 'grid'),
('AquaInnovations', 'SeaBreezeJournal', 80, 'hard', 'Bahamas', 'blank'),
('RainforestReflections', 'JungleExplorer', 150, 'soft', 'Brazil', 'lined'),
('HeritageCraft', 'CulturalLegacy', 120, 'hard', 'Greece', 'dotted'),
('MountainMajesty', 'AlpineSketch', 96, 'soft', 'Switzerland', 'grid'),
('WhimsicalWonders', 'FantasyScript', 100, 'hard', 'Neverland', 'lined');