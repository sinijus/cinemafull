INSERT INTO cinema.country (name) VALUES ('Prantsusmaa');
INSERT INTO cinema.country (name) VALUES ('Saksamaa');
INSERT INTO cinema.country (name) VALUES ('Rootsi');
INSERT INTO cinema.country (name) VALUES ('Eesti');
INSERT INTO cinema.country (name) VALUES ('Taani');
INSERT INTO cinema.country (name) VALUES ('Island');
INSERT INTO cinema.country (name) VALUES ('USA');
INSERT INTO cinema.country (name) VALUES ('Inglismaa');
INSERT INTO cinema.country (name) VALUES ('Soome');
INSERT INTO cinema.country (name) VALUES ('Iiri');
INSERT INTO cinema.country (name) VALUES ('Mehhiko');
INSERT INTO cinema.country (name) VALUES ('Peruu');
INSERT INTO cinema.country (name) VALUES ('Itaalia');

INSERT INTO cinema.language (name) VALUES ('prantsuse');
INSERT INTO cinema.language (name) VALUES ('saksa');
INSERT INTO cinema.language (name) VALUES ('rootsi');
INSERT INTO cinema.language (name) VALUES ('eesti');
INSERT INTO cinema.language (name) VALUES ('taani');
INSERT INTO cinema.language (name) VALUES ('islandi');
INSERT INTO cinema.language (name) VALUES ('inglise');
INSERT INTO cinema.language (name) VALUES ('vene');
INSERT INTO cinema.language (name) VALUES ('itaalia');
INSERT INTO cinema.language (name) VALUES ('hispaania');

INSERT INTO cinema.genre (name) VALUES ('Tegevus');
INSERT INTO cinema.genre (name) VALUES ('Komöödia');
INSERT INTO cinema.genre (name) VALUES ('Romantika');
INSERT INTO cinema.genre (name) VALUES ('Ajalooline');
INSERT INTO cinema.genre (name) VALUES ('Draama');
INSERT INTO cinema.genre (name) VALUES ('Muusikaline');
INSERT INTO cinema.genre (name) VALUES ('Ulme');
INSERT INTO cinema.genre (name) VALUES ('Psühholoogiline');
INSERT INTO cinema.genre (name) VALUES ('Õudus');
INSERT INTO cinema.genre (name) VALUES ('Erootiline');
INSERT INTO cinema.genre (name) VALUES ('Lastefilm');
INSERT INTO cinema.genre (name) VALUES ('Animafilm');
INSERT INTO cinema.genre (name) VALUES ('Müsteerium');
INSERT INTO cinema.genre (name) VALUES ('Biograafiline');
INSERT INTO cinema.genre (name) VALUES ('Seiklus');
INSERT INTO cinema.genre (name) VALUES ('Pere');
INSERT INTO cinema.genre (name) VALUES ('Dokumentaal');

INSERT INTO cinema.restriction (name) VALUES ('Perefilm');
INSERT INTO cinema.restriction (name) VALUES ('Alla 12 a. keelatud');
INSERT INTO cinema.restriction (name) VALUES ('Alla 14 a. keelatud');
INSERT INTO cinema.restriction (name) VALUES ('Alla 16 a. keelatud');

INSERT INTO cinema.cinema_user (name) VALUES ('testkasutaja');

INSERT INTO cinema.hall (name, seats_no) VALUES ('Peasaal', 120);

INSERT INTO cinema.director (name) VALUES ('David Lynch');
INSERT INTO cinema.director (name) VALUES ('Werner Herzog');
INSERT INTO cinema.director (name) VALUES ('Sergio Leone');
INSERT INTO cinema.director (name) VALUES ('Nikolaj Arcel');
INSERT INTO cinema.director (name) VALUES ('John Carney');
INSERT INTO cinema.director (name) VALUES ('Margus Paju');
INSERT INTO cinema.director (name) VALUES ('Anna Hints');

INSERT INTO cinema.movie (title, description, length, release_year)
VALUES ('Blue Velvet',
        'David Lynchi hallutsinogeenne, sensuaalne müsteerium. Pealtnäha tuttavlikus väikeses Ameerika linnas leiab noor koolipoiss Jeffrey Beaumont (Kyle Maclachlan) inimkõrva. Asja uurima hakates avastab noormees linna põrandaaluse pahupoole, kus lokkab prostitutsioon, vägivald ja perverssus. Suutmata oma uudishimu taltsutada, mässib Jeff end kauni lauljanna Dorothy Vallensi (Isabella Rossellini) ja psühhopaat Frank Boothi (Dennis Hopper) vahelisse konflikti.
‘Blue Velvet’ teostub binaarses maagilise realismi maailmas, kus üleloomulikud nähtused sulanduvad kokku loomuliku, meile harjumuspärase maailmaga. Lynchilikult luupainajalik ja psühhoanalüütiline vis-à-vis moment Varju arhetüübiga.',
            120, 1986);
INSERT INTO cinema.movie (title, description, length, release_year)
VALUES ('Aguirre, Jumala viha',
        'Korduvalt maailma parimate filmide hulka valitud „Aguirre, Jumala viha“ on üks Herzogi kuulsaimaid töid. See koondab endasse tema teostes esinevad korduvad teemad: looduse üleolek inimesest, inimeste julmus ja võimuiha, äärmuslikes oludes ellujäämine ja suured unistused.
Juba filmi alguskaader, kus mikroskoopilisena näiv inimkolonn ronib mööda tohutu mäe nõlva, seab looduse ja inimese suhte õigesse mastaapi. On 1560. aasta ja Hispaania konkistadoorid otsivad Lõuna-Ameerika džunglis muinasjutulist kullalinna El Doradot. Džungli julmus põhjustab rändajates mässu ning nende juhiks kerkib hulljulge ohvitser Don Lope de Aguirre. Seltskond jätkab reisi piki Amazonast, mille kallastel varitsevad verejanulised indiaanlased. Parvetajaid painavad kuumus, niiskus ja hirm tihenevad kollektiivseks hulluseks ja lõpuks maksab loodus kätte.',
            93, 1972);
INSERT INTO cinema.movie (title, description, length, release_year)
VALUES ('Hea, paha ja inetu',
        'Edela-USAs Kodusõja ajal on salapärane tundmatu Joe (Clint Eastwood) ja Mehhiko bandiit Tuco (Eli Wallach) sõlminud kummalise kokkuleppe – Joe teenib Tuco püüdmise eest lunarahasid ning päästab ta seejärel poomisest. Üsna pea kaovad asjad aga kontrolli alt ning mehed leiavad end võidujooksus kolmandaga, et kõrbest leida soldati maha maetud $20,000.
Ennio Morricone suurepärase originaalmuusikaga legendaarne spagetivestern.',
            178, 1986);
INSERT INTO cinema.movie (title, description, length, release_year)
VALUES ('Tõotatud maa',
        'Aastal 1755 asub vaesunud kapten Ludvig Kahlen vallutama karmi ja asustamata Taani nõmme-ala näiliselt võimatul eesmärgil - ehitada koloonia kuninga nimel. Vastutasuks saab ta endale väga soovitud kuningliku nime. Kuid selle piirkonna ainuvalitseja, halastamatu Frederik de Schinkel, usub, et see maa kuulub talle. Kui de Schinkel saab teada, et teenija Ann Barbara ja tema teenistujast abikaasa on põgenenud varjupaika Kahleni juurde, vannub privileegidele pretendeeriv ja pahatahtlik valitseja kättemaksu ning teeb kõik endast oleneva, et kapten sealt minema ajada. Kahlen ei lase end hirmutada ja võtab vastu ebavõrdse võitluse - riskides mitte ainult oma eluga, vaid ka ümberkaudsete võõraste peredega.',
            120, 2023);
INSERT INTO cinema.movie (title, description, length, release_year)
VALUES ('Once',
        'Dublinis elatist teeniv tänavamuusik (Glen Hansard) tutvub ühel päeval võluva tšehhi tüdrukuga (Markéta Irglová) ning nad veedavad koos unustamatu nädala. Noored kirjutavad koos lugusteevad proove ja salvestavad laulud, milles on kokku võetud nende kahe unikaalne armastuslugu.
Film on võitnud erinevaid auhindu, sealhulgas parima filmilaulu Oscari („Falling Slowly“) ning Sundance ja Dublini filmifestivali publikuauhinna. ',
            85, 2007);
INSERT INTO cinema.movie (title, description, length, release_year)
VALUES ('Supilinna Salaselts',
        'Mari, Sadu, Olav ja Anton on neli Supilinna last, kelle rõõmus argipäev pööratakse pea peale, kui nende kodulinna tabab salapärane mürgitus, mis pooled linna täiskasvanud lasteks muudab. Lastel on lahenduse leidmiseks aega vaid 48 tundi. Algab peadpööritav seiklus, mis viib lapsed kõige ootamatumatesse paikadesse nii maa peal kui ka maa all. Praeguse kodulinna kõrval õpivad nad tundma ühte teist, aastatetagust Tartut, teejuhiks Mari vanaisa käest saadud märkmik salapäraste vihjetega.',
            120, 2015);
INSERT INTO cinema.movie (title, description, length, release_year)
VALUES ('Igaüks iseenda eest ja Jumal kõigi vastu',
        'Saksa väikelinna väljakult leitakse räbalates noormees. Tal on peos kiri, milles palutakse nooruki eest hoolitseda. Poiss ei räägi sõnagi ja oskab vaevu püsti seista. Linlased võtavad ta oma hoole alla ning kui noormees lõpuks õpib rääkima, jutustab ta, et on kogu elu olnud keldrisse suletud. Kaspar Hauseri lugu on huvitanud inimesi juba ligi kakssada aastat. Milline koletis peidab last maailma eest ja kas on võimalik kasvada inimeseks ilma inimlike kontaktideta?
Werner Herzogi filmi aluseks on 1828. aastast pärit originaaldokumendid ja kirjad. See on poeetiline ja kurvameelne lugu inimliku julmuse tagajärgedest. Kurjus peidab end nii pimedas keldris kui ka ahnete inimeste hulgas, kes kasutavad Hauserit ära – kord tsirkuselooma, kord kõrgema seltskonna kurioosumina. Kaspar Hauser ei tunne teiste inimeste seltskonnast rõõmu, sest usaldus on talle on võõras. Ta loob endale oma filosoofilise mõtteviisi ja üritab sellega maailma määratleda, kuid harukordse mineviku tõttu mõistetakse teda üha valesti. Tema lõpp on traagiline nagu teisitimõtlejatel ikka. „Inimesed on mulle hundid,“ nendib Kaspar Hauser filmis.',
            110, 1974);
INSERT INTO cinema.movie (title, description, length, release_year)
VALUES ('Savvusanna sõsarad',
        'Esimese Eesti dokumentaalfilmina maineka Sundance´i filmifestivali võistlusprogrammis esilinastunud „Savvusanna sõsarad“ on kaasaegne portreefilm naistest, kes suitsusauna kaitsvas pimeduses kokku tulevad, oma sügavamaid saladusi jagavad ning kehasse kogunenud häbi ja valu maha pesevad.',
            89, 2023);

INSERT INTO cinema.movie_country (movie_id, country_id) VALUES (1, 7);
INSERT INTO cinema.movie_country (movie_id, country_id) VALUES (2, 2);
INSERT INTO cinema.movie_country (movie_id, country_id) VALUES (2, 11);
INSERT INTO cinema.movie_country (movie_id, country_id) VALUES (2, 12);
INSERT INTO cinema.movie_country (movie_id, country_id) VALUES (3, 13);
INSERT INTO cinema.movie_country (movie_id, country_id) VALUES (4, 5);
INSERT INTO cinema.movie_country (movie_id, country_id) VALUES (4, 2);
INSERT INTO cinema.movie_country (movie_id, country_id) VALUES (4, 3);
INSERT INTO cinema.movie_country (movie_id, country_id) VALUES (5, 10);
INSERT INTO cinema.movie_country (movie_id, country_id) VALUES (6, 4);
INSERT INTO cinema.movie_country (movie_id, country_id) VALUES (7, 2);
INSERT INTO cinema.movie_country (movie_id, country_id) VALUES (8, 4);

INSERT INTO cinema.movie_genre (movie_id, genre_id) VALUES (1, 5);
INSERT INTO cinema.movie_genre (movie_id, genre_id) VALUES (1, 13);
INSERT INTO cinema.movie_genre (movie_id, genre_id) VALUES (2, 1);
INSERT INTO cinema.movie_genre (movie_id, genre_id) VALUES (2, 15);
INSERT INTO cinema.movie_genre (movie_id, genre_id) VALUES (2, 14);
INSERT INTO cinema.movie_genre (movie_id, genre_id) VALUES (3, 15);
INSERT INTO cinema.movie_genre (movie_id, genre_id) VALUES (4, 14);
INSERT INTO cinema.movie_genre (movie_id, genre_id) VALUES (4, 5);
INSERT INTO cinema.movie_genre (movie_id, genre_id) VALUES (4, 4);
INSERT INTO cinema.movie_genre (movie_id, genre_id) VALUES (5, 5);
INSERT INTO cinema.movie_genre (movie_id, genre_id) VALUES (5, 3);
INSERT INTO cinema.movie_genre (movie_id, genre_id) VALUES (5, 6);
INSERT INTO cinema.movie_genre (movie_id, genre_id) VALUES (6, 1);
INSERT INTO cinema.movie_genre (movie_id, genre_id) VALUES (6, 15);
INSERT INTO cinema.movie_genre (movie_id, genre_id) VALUES (6, 16);
INSERT INTO cinema.movie_genre (movie_id, genre_id) VALUES (7, 14);
INSERT INTO cinema.movie_genre (movie_id, genre_id) VALUES (7, 5);
INSERT INTO cinema.movie_genre (movie_id, genre_id) VALUES (7, 4);
INSERT INTO cinema.movie_genre (movie_id, genre_id) VALUES (8, 17);

INSERT INTO cinema.movie_director (movie_id, director_id) VALUES (1, 1);
INSERT INTO cinema.movie_director (movie_id, director_id) VALUES (2, 2);
INSERT INTO cinema.movie_director (movie_id, director_id) VALUES (3, 3);
INSERT INTO cinema.movie_director (movie_id, director_id) VALUES (4, 4);
INSERT INTO cinema.movie_director (movie_id, director_id) VALUES (5, 5);
INSERT INTO cinema.movie_director (movie_id, director_id) VALUES (6, 6);
INSERT INTO cinema.movie_director (movie_id, director_id) VALUES (7, 2);
INSERT INTO cinema.movie_director (movie_id, director_id) VALUES (8, 7);

INSERT INTO cinema.movie_language (movie_id, language_id) VALUES (1, 7);
INSERT INTO cinema.movie_language (movie_id, language_id) VALUES (2, 2);
INSERT INTO cinema.movie_language (movie_id, language_id) VALUES (3, 7);
INSERT INTO cinema.movie_language (movie_id, language_id) VALUES (3, 9);
INSERT INTO cinema.movie_language (movie_id, language_id) VALUES (3, 10);
INSERT INTO cinema.movie_language (movie_id, language_id) VALUES (4, 5);
INSERT INTO cinema.movie_language (movie_id, language_id) VALUES (4, 2);
INSERT INTO cinema.movie_language (movie_id, language_id) VALUES (5, 7);
INSERT INTO cinema.movie_language (movie_id, language_id) VALUES (6, 4);
INSERT INTO cinema.movie_language (movie_id, language_id) VALUES (7, 2);
INSERT INTO cinema.movie_language (movie_id, language_id) VALUES (7, 7);
INSERT INTO cinema.movie_language (movie_id, language_id) VALUES (8, 4);

INSERT INTO cinema.movie_subtitles (movie_id, language_id) VALUES (1, 4);
INSERT INTO cinema.movie_subtitles (movie_id, language_id) VALUES (1, 8);
INSERT INTO cinema.movie_subtitles (movie_id, language_id) VALUES (2, 4);
INSERT INTO cinema.movie_subtitles (movie_id, language_id) VALUES (2, 7);
INSERT INTO cinema.movie_subtitles (movie_id, language_id) VALUES (3, 4);
INSERT INTO cinema.movie_subtitles (movie_id, language_id) VALUES (3, 8);
INSERT INTO cinema.movie_subtitles (movie_id, language_id) VALUES (4, 4);
INSERT INTO cinema.movie_subtitles (movie_id, language_id) VALUES (4, 7);
INSERT INTO cinema.movie_subtitles (movie_id, language_id) VALUES (5, 4);
INSERT INTO cinema.movie_subtitles (movie_id, language_id) VALUES (6, 7);
INSERT INTO cinema.movie_subtitles (movie_id, language_id) VALUES (6, 2);
INSERT INTO cinema.movie_subtitles (movie_id, language_id) VALUES (7, 4);
INSERT INTO cinema.movie_subtitles (movie_id, language_id) VALUES (7, 7);
INSERT INTO cinema.movie_subtitles (movie_id, language_id) VALUES (8, 4);
INSERT INTO cinema.movie_subtitles (movie_id, language_id) VALUES (8, 7);

INSERT INTO cinema.movie_restriction (movie_id, restriction_id) VALUES (1, 2);
INSERT INTO cinema.movie_restriction (movie_id, restriction_id) VALUES (2, 2);
INSERT INTO cinema.movie_restriction (movie_id, restriction_id) VALUES (6, 1);
INSERT INTO cinema.movie_restriction (movie_id, restriction_id) VALUES (4, 4);

DO
$$
    BEGIN
        FOR i IN 1..12 LOOP
                FOR j IN 1..10 LOOP
                        INSERT INTO cinema.seat (hall_id, row, number) VALUES (1, i, j); -- Omitting 'id' column as it's set to default
                    END LOOP;
            END LOOP;
    END
$$;





