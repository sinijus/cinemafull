INSERT INTO cinema.country (id, name)
VALUES (default, 'Prantsusmaa');
INSERT INTO cinema.country (id, name)
VALUES (default, 'Saksamaa');
INSERT INTO cinema.country (id, name)
VALUES (default, 'Rootsi');
INSERT INTO cinema.country (id, name)
VALUES (default, 'Eesti');
INSERT INTO cinema.country (id, name)
VALUES (default, 'Taani');
INSERT INTO cinema.country (id, name)
VALUES (default, 'Island');
INSERT INTO cinema.country (id, name)
VALUES (default, 'USA');
INSERT INTO cinema.country (id, name)
VALUES (default, 'Inglismaa');
INSERT INTO cinema.country (id, name)
VALUES (default, 'Soome');
INSERT INTO cinema.country (id, name)
VALUES (default, 'Iiri');
INSERT INTO cinema.country (id, name)
VALUES (default, 'Mehhiko');
INSERT INTO cinema.country (id, name)
VALUES (default, 'Peruu');
INSERT INTO cinema.country (id, name)
VALUES (default, 'Itaalia');

INSERT INTO cinema.language (id, name)
VALUES (default, 'prantsuse');
INSERT INTO cinema.language (id, name)
VALUES (default, 'saksa');
INSERT INTO cinema.language (id, name)
VALUES (default, 'rootsi');
INSERT INTO cinema.language (id, name)
VALUES (default, 'eesti');
INSERT INTO cinema.language (id, name)
VALUES (default, 'taani');
INSERT INTO cinema.language (id, name)
VALUES (default, 'islandi');
INSERT INTO cinema.language (id, name)
VALUES (default, 'inglise');
INSERT INTO cinema.language (id, name)
VALUES (default, 'vene');
INSERT INTO cinema.language (id, name)
VALUES (default, 'itaalia');
INSERT INTO cinema.language (id, name)
VALUES (default, 'hispaania');

INSERT INTO cinema.genre (id, name)
VALUES (default, 'Tegevus');
INSERT INTO cinema.genre (id, name)
VALUES (default, 'Komöödia');
INSERT INTO cinema.genre (id, name)
VALUES (default, 'Romantika');
INSERT INTO cinema.genre (id, name)
VALUES (default, 'Ajalooline');
INSERT INTO cinema.genre (id, name)
VALUES (default, 'Draama');
INSERT INTO cinema.genre (id, name)
VALUES (default, 'Muusikaline');
INSERT INTO cinema.genre (id, name)
VALUES (default, 'Ulme');
INSERT INTO cinema.genre (id, name)
VALUES (default, 'Psühholoogiline');
INSERT INTO cinema.genre (id, name)
VALUES (default, 'Õudus');
INSERT INTO cinema.genre (id, name)
VALUES (default, 'Erootiline');
INSERT INTO cinema.genre (id, name)
VALUES (default, 'Lastefilm');
INSERT INTO cinema.genre (id, name)
VALUES (default, 'Animafilm');
INSERT INTO cinema.genre (id, name)
VALUES (default, 'Müsteerium');
INSERT INTO cinema.genre (id, name)
VALUES (default, 'Biograafiline');
INSERT INTO cinema.genre (id, name)
VALUES (default, 'Seiklus');
INSERT INTO cinema.genre (id, name)
VALUES (default, 'Pere');
INSERT INTO cinema.genre (id, name)
VALUES (default, 'Dokumentaal');

INSERT INTO cinema.restriction (id, name)
VALUES (default, 'Perefilm');
INSERT INTO cinema.restriction (id, name)
VALUES (default, 'Alla 12 a. keelatud');
INSERT INTO cinema.restriction (id, name)
VALUES (default, 'Alla 14 a. keelatud');
INSERT INTO cinema.restriction (id, name)
VALUES (default, 'Alla 16 a. keelatud');

INSERT INTO cinema.user (id, name)
VALUES (default, 'testkasutaja');

INSERT INTO cinema.hall (id, name, seats_no)
VALUES (default, 'Peasaal', 120);

INSERT INTO cinema.director (id, name)
VALUES (default, 'David Lynch');
INSERT INTO cinema.director (id, name)
VALUES (default, 'Werner Herzog');
INSERT INTO cinema.director (id, name)
VALUES (default, 'Sergio Leone');
INSERT INTO cinema.director (id, name)
VALUES (default, 'Nikolaj Arcel');
INSERT INTO cinema.director (id, name)
VALUES (default, 'John Carney');
INSERT INTO cinema.director (id, name)
VALUES (default, 'Margus Paju');
INSERT INTO cinema.director (id, name)
VALUES (default, 'Anna Hints');

INSERT INTO cinema.movie (id, title, description, length, release_year)
VALUES (default, 'Blue Velvet',
        'David Lynchi hallutsinogeenne, sensuaalne müsteerium. Pealtnäha tuttavlikus väikeses Ameerika linnas leiab noor koolipoiss Jeffrey Beaumont (Kyle Maclachlan) inimkõrva. Asja uurima hakates avastab noormees linna põrandaaluse pahupoole, kus lokkab prostitutsioon, vägivald ja perverssus. Suutmata oma uudishimu taltsutada, mässib Jeff end kauni lauljanna Dorothy Vallensi (Isabella Rossellini) ja psühhopaat Frank Boothi (Dennis Hopper) vahelisse konflikti.
‘Blue Velvet’ teostub binaarses maagilise realismi maailmas, kus üleloomulikud nähtused sulanduvad kokku loomuliku, meile harjumuspärase maailmaga. Lynchilikult luupainajalik ja psühhoanalüütiline vis-à-vis moment Varju arhetüübiga.',
            120, 1986);
INSERT INTO cinema.movie (id, title, description, length, release_year)
VALUES (default, 'Aguirre, Jumala viha',
        'Korduvalt maailma parimate filmide hulka valitud „Aguirre, Jumala viha“ on üks Herzogi kuulsaimaid töid. See koondab endasse tema teostes esinevad korduvad teemad: looduse üleolek inimesest, inimeste julmus ja võimuiha, äärmuslikes oludes ellujäämine ja suured unistused.
Juba filmi alguskaader, kus mikroskoopilisena näiv inimkolonn ronib mööda tohutu mäe nõlva, seab looduse ja inimese suhte õigesse mastaapi. On 1560. aasta ja Hispaania konkistadoorid otsivad Lõuna-Ameerika džunglis muinasjutulist kullalinna El Doradot. Džungli julmus põhjustab rändajates mässu ning nende juhiks kerkib hulljulge ohvitser Don Lope de Aguirre. Seltskond jätkab reisi piki Amazonast, mille kallastel varitsevad verejanulised indiaanlased. Parvetajaid painavad kuumus, niiskus ja hirm tihenevad kollektiivseks hulluseks ja lõpuks maksab loodus kätte.',
            93, 1972);
INSERT INTO cinema.movie (id, title, description, length, release_year)
VALUES (default, 'Hea, paha ja inetu',
        'Edela-USAs Kodusõja ajal on salapärane tundmatu Joe (Clint Eastwood) ja Mehhiko bandiit Tuco (Eli Wallach) sõlminud kummalise kokkuleppe – Joe teenib Tuco püüdmise eest lunarahasid ning päästab ta seejärel poomisest. Üsna pea kaovad asjad aga kontrolli alt ning mehed leiavad end võidujooksus kolmandaga, et kõrbest leida soldati maha maetud $20,000.
Ennio Morricone suurepärase originaalmuusikaga legendaarne spagetivestern.',
            178, 1986);
INSERT INTO cinema.movie (id, title, description, length, release_year)
VALUES (default, 'Tõotatud maa',
        'Aastal 1755 asub vaesunud kapten Ludvig Kahlen vallutama karmi ja asustamata Taani nõmme-ala näiliselt võimatul eesmärgil - ehitada koloonia kuninga nimel. Vastutasuks saab ta endale väga soovitud kuningliku nime. Kuid selle piirkonna ainuvalitseja, halastamatu Frederik de Schinkel, usub, et see maa kuulub talle. Kui de Schinkel saab teada, et teenija Ann Barbara ja tema teenistujast abikaasa on põgenenud varjupaika Kahleni juurde, vannub privileegidele pretendeeriv ja pahatahtlik valitseja kättemaksu ning teeb kõik endast oleneva, et kapten sealt minema ajada. Kahlen ei lase end hirmutada ja võtab vastu ebavõrdse võitluse - riskides mitte ainult oma eluga, vaid ka ümberkaudsete võõraste peredega.',
            120, 2023);
INSERT INTO cinema.movie (id, title, description, length, release_year)
VALUES (default, 'Once',
        'Dublinis elatist teeniv tänavamuusik (Glen Hansard) tutvub ühel päeval võluva tšehhi tüdrukuga (Markéta Irglová) ning nad veedavad koos unustamatu nädala. Noored kirjutavad koos lugusid, teevad proove ja salvestavad laulud, milles on kokku võetud nende kahe unikaalne armastuslugu.
Film on võitnud erinevaid auhindu, sealhulgas parima filmilaulu Oscari („Falling Slowly“) ning Sundance ja Dublini filmifestivali publikuauhinna. ',
            85, 2007);
INSERT INTO cinema.movie (id, title, description, length, release_year)
VALUES (default, 'Supilinna Salaselts',
        'Mari, Sadu, Olav ja Anton on neli Supilinna last, kelle rõõmus argipäev pööratakse pea peale, kui nende kodulinna tabab salapärane mürgitus, mis pooled linna täiskasvanud lasteks muudab. Lastel on lahenduse leidmiseks aega vaid 48 tundi. Algab peadpööritav seiklus, mis viib lapsed kõige ootamatumatesse paikadesse nii maa peal kui ka maa all. Praeguse kodulinna kõrval õpivad nad tundma ühte teist, aastatetagust Tartut, teejuhiks Mari vanaisa käest saadud märkmik salapäraste vihjetega.',
            120, 2015);
INSERT INTO cinema.movie (id, title, description, length, release_year)
VALUES (default, 'Igaüks iseenda eest ja Jumal kõigi vastu',
        'Saksa väikelinna väljakult leitakse räbalates noormees. Tal on peos kiri, milles palutakse nooruki eest hoolitseda. Poiss ei räägi sõnagi ja oskab vaevu püsti seista. Linlased võtavad ta oma hoole alla ning kui noormees lõpuks õpib rääkima, jutustab ta, et on kogu elu olnud keldrisse suletud. Kaspar Hauseri lugu on huvitanud inimesi juba ligi kakssada aastat. Milline koletis peidab last maailma eest ja kas on võimalik kasvada inimeseks ilma inimlike kontaktideta?
Werner Herzogi filmi aluseks on 1828. aastast pärit originaaldokumendid ja kirjad. See on poeetiline ja kurvameelne lugu inimliku julmuse tagajärgedest. Kurjus peidab end nii pimedas keldris kui ka ahnete inimeste hulgas, kes kasutavad Hauserit ära – kord tsirkuselooma, kord kõrgema seltskonna kurioosumina. Kaspar Hauser ei tunne teiste inimeste seltskonnast rõõmu, sest usaldus on talle on võõras. Ta loob endale oma filosoofilise mõtteviisi ja üritab sellega maailma määratleda, kuid harukordse mineviku tõttu mõistetakse teda üha valesti. Tema lõpp on traagiline nagu teisitimõtlejatel ikka. „Inimesed on mulle hundid,“ nendib Kaspar Hauser filmis.',
            110, 1974);
INSERT INTO cinema.movie (id, title, description, length, release_year)
VALUES (default, 'Savvusanna sõsarad',
        'Esimese Eesti dokumentaalfilmina maineka Sundance´i filmifestivali võistlusprogrammis esilinastunud „Savvusanna sõsarad“ on kaasaegne portreefilm naistest, kes suitsusauna kaitsvas pimeduses kokku tulevad, oma sügavamaid saladusi jagavad ning kehasse kogunenud häbi ja valu maha pesevad.',
            89, 2023);


INSERT INTO cinema.movie_country (id, movie_id, country_id) VALUES (default, 1, 7);
INSERT INTO cinema.movie_country (id, movie_id, country_id) VALUES (default, 2, 2);
INSERT INTO cinema.movie_country (id, movie_id, country_id) VALUES (default, 2, 11);
INSERT INTO cinema.movie_country (id, movie_id, country_id) VALUES (default, 2, 12);
INSERT INTO cinema.movie_country (id, movie_id, country_id) VALUES (default, 3, 13);
INSERT INTO cinema.movie_country (id, movie_id, country_id) VALUES (default, 4, 5);
INSERT INTO cinema.movie_country (id, movie_id, country_id) VALUES (default, 4, 2);
INSERT INTO cinema.movie_country (id, movie_id, country_id) VALUES (default, 4, 3);
INSERT INTO cinema.movie_country (id, movie_id, country_id) VALUES (default, 5, 10);
INSERT INTO cinema.movie_country (id, movie_id, country_id) VALUES (default, 6, 4);
INSERT INTO cinema.movie_country (id, movie_id, country_id) VALUES (default, 7, 2);
INSERT INTO cinema.movie_country (id, movie_id, country_id) VALUES (default, 8, 4);

INSERT INTO cinema.movie_genre (id, movie_id, genre_id) VALUES (default, 1, 5);
INSERT INTO cinema.movie_genre (id, movie_id, genre_id) VALUES (default, 1, 13);
INSERT INTO cinema.movie_genre (id, movie_id, genre_id) VALUES (default, 2, 1);
INSERT INTO cinema.movie_genre (id, movie_id, genre_id) VALUES (default, 2, 15);
INSERT INTO cinema.movie_genre (id, movie_id, genre_id) VALUES (default, 2, 14);
INSERT INTO cinema.movie_genre (id, movie_id, genre_id) VALUES (default, 3, 15);
INSERT INTO cinema.movie_genre (id, movie_id, genre_id) VALUES (default, 4, 14);
INSERT INTO cinema.movie_genre (id, movie_id, genre_id) VALUES (default, 4, 5);
INSERT INTO cinema.movie_genre (id, movie_id, genre_id) VALUES (default, 4, 4);
INSERT INTO cinema.movie_genre (id, movie_id, genre_id) VALUES (default, 5, 5);
INSERT INTO cinema.movie_genre (id, movie_id, genre_id) VALUES (default, 5, 3);
INSERT INTO cinema.movie_genre (id, movie_id, genre_id) VALUES (default, 5, 6);
INSERT INTO cinema.movie_genre (id, movie_id, genre_id) VALUES (default, 6, 1);
INSERT INTO cinema.movie_genre (id, movie_id, genre_id) VALUES (default, 6, 15);
INSERT INTO cinema.movie_genre (id, movie_id, genre_id) VALUES (default, 6, 16);
INSERT INTO cinema.movie_genre (id, movie_id, genre_id) VALUES (default, 7, 14);
INSERT INTO cinema.movie_genre (id, movie_id, genre_id) VALUES (default, 7, 5);
INSERT INTO cinema.movie_genre (id, movie_id, genre_id) VALUES (default, 7, 4);
INSERT INTO cinema.movie_genre (id, movie_id, genre_id) VALUES (default, 8, 17);

INSERT INTO cinema.movie_director (id, movie_id, director_id) VALUES (default, 1, 1);
INSERT INTO cinema.movie_director (id, movie_id, director_id) VALUES (default, 2, 2);
INSERT INTO cinema.movie_director (id, movie_id, director_id) VALUES (default, 3, 3);
INSERT INTO cinema.movie_director (id, movie_id, director_id) VALUES (default, 4, 4);
INSERT INTO cinema.movie_director (id, movie_id, director_id) VALUES (default, 5, 5);
INSERT INTO cinema.movie_director (id, movie_id, director_id) VALUES (default, 6, 6);
INSERT INTO cinema.movie_director (id, movie_id, director_id) VALUES (default, 7, 2);
INSERT INTO cinema.movie_director (id, movie_id, director_id) VALUES (default, 8, 7);

INSERT INTO cinema.movie_language (id, movie_id, language_id) VALUES (default, 1, 7);
INSERT INTO cinema.movie_language (id, movie_id, language_id) VALUES (default, 2, 2);
INSERT INTO cinema.movie_language (id, movie_id, language_id) VALUES (default, 3, 7);
INSERT INTO cinema.movie_language (id, movie_id, language_id) VALUES (default, 3, 9);
INSERT INTO cinema.movie_language (id, movie_id, language_id) VALUES (default, 3, 10);
INSERT INTO cinema.movie_language (id, movie_id, language_id) VALUES (default, 4, 5);
INSERT INTO cinema.movie_language (id, movie_id, language_id) VALUES (default, 4, 2);
INSERT INTO cinema.movie_language (id, movie_id, language_id) VALUES (default, 5, 7);
INSERT INTO cinema.movie_language (id, movie_id, language_id) VALUES (default, 6, 4);
INSERT INTO cinema.movie_language (id, movie_id, language_id) VALUES (default, 7, 2);
INSERT INTO cinema.movie_language (id, movie_id, language_id) VALUES (default, 7, 7);
INSERT INTO cinema.movie_language (id, movie_id, language_id) VALUES (default, 8, 4);

INSERT INTO cinema.movie_restriction (id, movie_id, restriction_id) VALUES (default, 1, 4);

-- DO
-- $$
--     BEGIN
--         FOR i IN 1..12 LOOP
--                 FOR j IN 1..10 LOOP
--                         INSERT INTO cinema.seat (id, hall_id, row, number) VALUES (default, 1, 1, 1); -- Omitting 'id' column as it's set to default
--                     END LOOP;
--             END LOOP;
--     END
-- $$;





