package com.example.testuxproject;

import android.os.Bundle;

import com.example.testuxproject.homepage.GameItems;

import java.util.ArrayList;

public class GlobalData {
    public static String userEmail = "rere@gmail.com";
    public static String userPassword = "12345678";
    public static String userName;

    public static ArrayList<GameItems> games = new ArrayList<>();

//    filter
    public static ArrayList<GameItems> filterGameByType (String type) {
        ArrayList<GameItems> filtered = new ArrayList<>();
        for (GameItems game: games) {
            if (game.getGameType().equalsIgnoreCase(type)) {
                filtered.add(game);
            }
        }
        return filtered;
    }


    public static void init(){
        if (!games.isEmpty()) return;

//        mobile legend
        GameItems mobilelegend = new GameItems(R.drawable.wallpaper_mobilelegend, R.drawable.mobilelegend_logo, "Mobile Legend", 4.4, "Action", "mobile");
        mobilelegend.getItems().add(new ItemGameModel("Blade of Despair", "DonShop", "1500", R.drawable.mobilelegend_bladeofdespair));
        mobilelegend.getItems().add(new ItemGameModel("Bloodlust Axe", "PolShop", "800", R.drawable.mobilelegend_bloodlustaxe));
        mobilelegend.getItems().add(new ItemGameModel("Athena Shield", "JingShop", "1000", R.drawable.mobilelegend_athenashield));
        mobilelegend.getItems().add(new ItemGameModel("Antique Curasss", "BonShop", "1200", R.drawable.mobilelegend_antiquecurass));
        mobilelegend.getItems().add(new ItemGameModel("Holy Crystal", "LingShop", "800", R.drawable.mobilelegend_holycrystal));
        games.add(mobilelegend);

//        coc
        GameItems clashofclans = new GameItems(R.drawable.wallpaper_clashofclans, R.drawable.logoclashofclans, "Clash of Clans", 4.6, "Strategy", "mobile");
        clashofclans.getItems().add(new ItemGameModel("Bronze Pass","CilShop","300",R.drawable.clashofclans_bronzepass));
        clashofclans.getItems().add(new ItemGameModel("Silver Pass","BelShop","500",R.drawable.clashofclans_silverpass));
        clashofclans.getItems().add(new ItemGameModel("Gold Pass","AyShop","800",R.drawable.clashofclans_goldenpass));
        clashofclans.getItems().add(new ItemGameModel("Platinum Pass","GojoShop","1000",R.drawable.clashofclans_platinumpass));
        clashofclans.getItems().add(new ItemGameModel("Diamond Pass","YesShop","1200",R.drawable.clashofclans_diamondpass));
        games.add(clashofclans);

//        pubg
        GameItems pubg = new GameItems(R.drawable.wallpaper_pubg, R.drawable.pubg_logo, "PUBG", 4.3, "Strategy", "mobile");
        pubg.getItems().add(new ItemGameModel("Black Knight","PopShop","400",R.drawable.pubg_blackknight));
        pubg.getItems().add(new ItemGameModel("Lady of Blood","KoiShop","800",R.drawable.pubg_ladyofblood));
        pubg.getItems().add(new ItemGameModel("Modern Low","BenzShop","1000",R.drawable.pubg_modernlow));
        games.add(pubg);

//        pokemon
        GameItems pokemon = new GameItems(R.drawable.wallpaper_pokemongo,R.drawable.pokemon__logo, "Pokemon Go", 3.6, "Strategy", "mobile");
        pokemon.getItems().add(new ItemGameModel("100 Pokecoin","DinShop","200",R.drawable.pokemon_pokecoin));
        pokemon.getItems().add(new ItemGameModel("300 Pokecoin","FuShop","500",R.drawable.pokemon_pokecoin));
        pokemon.getItems().add(new ItemGameModel("500 Pokecoin","HonShop","800",R.drawable.pokemon_pokecoin));
        pokemon.getItems().add(new ItemGameModel("1000 Pokecoin","JayShop","1000",R.drawable.pokemon_pokecoin));
        pokemon.getItems().add(new ItemGameModel("3000 Pokecoin","GioShop","1500",R.drawable.pokemon_pokecoin));
        games.add(pokemon);

//        genshin impact
        GameItems genshinimpact = new GameItems(R.drawable.wallpaper_genshinimpact, R.drawable.genshin_logo, "Genshin Impact", 4.4, "Role-play", "mobile");
        genshinimpact.getItems().add(new ItemGameModel("60 Crystal","FunShop","300",R.drawable.genshin_crystal));
        genshinimpact.getItems().add(new ItemGameModel("300 Crystal","WibuShop","800",R.drawable.genshin_crystal));
        genshinimpact.getItems().add(new ItemGameModel("1000 Crystal","AraShop","1000",R.drawable.genshin_crystal));
        genshinimpact.getItems().add(new ItemGameModel("3000 Crystal","AnaShop","1200",R.drawable.genshin_crystal));
        genshinimpact.getItems().add(new ItemGameModel("6000 Crystal","DollShop","1500",R.drawable.genshin_crystal));
        games.add(genshinimpact);


//        valorant
        GameItems valorant = new GameItems(R.drawable.wallpaper_valorant, R.drawable.valorant_logo, "Valorant", 4.4, "Strategy", "PC");
        valorant.getItems().add(new ItemGameModel("Reaver Vandal","ValShop","800",R.drawable.valorant_reavervandal));
        valorant.getItems().add(new ItemGameModel("Ion Operator","MelShop","1400",R.drawable.valorant_ionoperator));
        valorant.getItems().add(new ItemGameModel("Prime Axe","JoeShop","2000",R.drawable.valorant_primeaxe));
        valorant.getItems().add(new ItemGameModel("Oni Phantom","BenShop","1000",R.drawable.valorant_oniphantom));
        valorant.getItems().add(new ItemGameModel("Glitchpop Vandal","KongShop","1200",R.drawable.valorant_glitchpopvandal));
        games.add(valorant);

//        rocket league
        GameItems rocketleague = new GameItems(R.drawable.wallpaper_rocketleague, R.drawable.rocketleague_logo, "Rocket League", 4.6, "Arcade", "PC");
        rocketleague.getItems().add(new ItemGameModel("Ronin GXT","JonShop","1000",R.drawable.rocketleague_roningxt));
        rocketleague.getItems().add(new ItemGameModel("R3MX GXT","PongShop","1200",R.drawable.rocketleague_r3mxgxt));
        rocketleague.getItems().add(new ItemGameModel("Tyranno GXT","KinShop","2000",R.drawable.rocketleague_tyrannogxt));
        rocketleague.getItems().add(new ItemGameModel("Outlaw GXT","LowShop","1500",R.drawable.rocketleague_outlawgxt));
        rocketleague.getItems().add(new ItemGameModel("Nexus GXT","TrollShop","1400",R.drawable.rocketleague_nexusgxt));
        games.add(rocketleague);

//        dota 2
        GameItems dota2 = new GameItems(R.drawable.wallpaper_dota2, R.drawable.dota2_logo, "DOTA 2", 4.3, "Action", "PC");
        dota2.getItems().add(new ItemGameModel("Dragon Knight","DotShop","1400",R.drawable.dota2_dragonknight));
        dota2.getItems().add(new ItemGameModel("Ember Spirit","MonkShop","1000",R.drawable.dota2_emberspirit));
        dota2.getItems().add(new ItemGameModel("Night Stalker","BishShop","1600",R.drawable.dota2_nightstalker));
        dota2.getItems().add(new ItemGameModel("Templar Assassin","BrenShop","800",R.drawable.dota2_templarassassin));
        dota2.getItems().add(new ItemGameModel("Troll Warload","GrayShop","1200",R.drawable.dota2_trollwarload));
        games.add(dota2);

//        fortnite
        GameItems fortnite = new GameItems(R.drawable.wallpaper_fortnite, R.drawable.fortnite_logo, "Fornite", 3.6, "Action", "PC");
        fortnite.getItems().add(new ItemGameModel("Finfin Flair","KolShop","600",R.drawable.fortnite_finfinflair));
        fortnite.getItems().add(new ItemGameModel("Brite Star","DolShop","800",R.drawable.fortnite_britestar));
        fortnite.getItems().add(new ItemGameModel("Freshly Forged","TelShop","400",R.drawable.fortnite_freshlyforged));
        fortnite.getItems().add(new ItemGameModel("Brave and Brite","YoonaShop","500",R.drawable.fortnite_braveandbrite));
        fortnite.getItems().add(new ItemGameModel("Pickross Bow","JinShop","1000",R.drawable.fortnite_pickrossbow));
        games.add(fortnite);

//        apex legend
        GameItems apexlegend = new GameItems(R.drawable.wallpaper_apexlegend, R.drawable.apex_logo, "Apex Legend", 4.4, "Action", "PC");
        apexlegend.getItems().add(new ItemGameModel("Baracuda Bundle","MolShop","800",R.drawable.apexlegend_baracudabundle));
        apexlegend.getItems().add(new ItemGameModel("Oni's Shadow","HanShop","1200",R.drawable.apexlegend_onishadow));
        apexlegend.getItems().add(new ItemGameModel("Silver Fox","LilShop","1000",R.drawable.apexlegend_silverfox));
        apexlegend.getItems().add(new ItemGameModel("Deputy of Death","BelShop","700",R.drawable.apexlegend_deputyofdeath));
        apexlegend.getItems().add(new ItemGameModel("Quarantine 22","BillShop","900",R.drawable.apexlegend_quarantine22));
        games.add(apexlegend);

//        uncharted
        GameItems uncharted = new GameItems(R.drawable.wallpaper_uncharted, R.drawable.uncharted_logo, "Uncharted", 4.4, "Action", "Console");
        uncharted.getItems().add(new ItemGameModel("Nathan Ring","LenShop","600",R.drawable.uncharted_nathanring));
        uncharted.getItems().add(new ItemGameModel("Antique Bronze","MinShop","800",R.drawable.uncharted_antiquebronze));
        uncharted.getItems().add(new ItemGameModel("Mayhem Shirt","RunShop","1000",R.drawable.uncharted_mayhemshirt));
        games.add(uncharted);

//        the last of us
        GameItems thelastofus = new GameItems(R.drawable.wallpaper_thelastofus, R.drawable.thelastofus_logo, "The Last of Us", 4.6, "Survival", "Console");
        thelastofus.getItems().add(new ItemGameModel("Fly Rise Shirt","GonShop","800",R.drawable.thelastofus_flyriseshirt));
        thelastofus.getItems().add(new ItemGameModel("Fire Rise Hoodie","KunShop","800",R.drawable.thelastofus_firerisehoodie));
        thelastofus.getItems().add(new ItemGameModel("Antique Silver","GenShop","1000",R.drawable.thelastofus_antiquesilver));
        games.add(thelastofus);

//        resident evil
        GameItems residentevil = new GameItems(R.drawable.wallpaper_residentevil, R.drawable.residentevil_logo, "Resident Evil", 4.3, "Survival", "Console");
        residentevil.getItems().add(new ItemGameModel("First Aid Spray","JunShop","400",R.drawable.residentevil_firstaidspray));
        residentevil.getItems().add(new ItemGameModel("Clark X-Ray","LanShop","600",R.drawable.residentevil_clarkxray));
        residentevil.getItems().add(new ItemGameModel("Helmet Key","BunShop","800",R.drawable.residentevil_helmetkey));
        games.add(residentevil);

//        god of war
        GameItems godofwar = new GameItems(R.drawable.wallpaper_godofwar, R.drawable.godofwar_logo, "God of War", 3.6, "Adventure", "Console");
        godofwar.getItems().add(new ItemGameModel("Blade of Olympus","TonShop","600",R.drawable.godofwar_bladeofolympus));
        godofwar.getItems().add(new ItemGameModel("Ice of Poseidon","LunShop","800",R.drawable.godofwar_iceofposeidon));
        godofwar.getItems().add(new ItemGameModel("Blades of Athena","CunShop","1000",R.drawable.godofwar_bladesofathena));
        games.add(godofwar);

//        tekken 8
        GameItems tekken8 = new GameItems(R.drawable.wallpaper_tekken8, R.drawable.tekken8_logo, "Tekken 8", 4.4, "Action", "Console");
        tekken8.getItems().add(new ItemGameModel("Jin Kazama","KinShop","1500",R.drawable.tekken8_jinkazama));
        tekken8.getItems().add(new ItemGameModel("Kazuya Mishima","HanShop","1200",R.drawable.tekken8_kazuyamishima));
        tekken8.getItems().add(new ItemGameModel("King","GimShop","1000",R.drawable.tekken8_king));
        games.add(tekken8);

//        mobile legend
        GameItems mobilelegendRecom = new GameItems(R.drawable.wallpaper_mobilelegend, R.drawable.mobilelegend_logo, "Mobile Legend", 4.4, "Action", "recommend");
        mobilelegend.getItems().add(new ItemGameModel("Blade of Despair", "DonShop", "1500", R.drawable.mobilelegend_bladeofdespair));
        mobilelegend.getItems().add(new ItemGameModel("Bloodlust Axe", "PolShop", "800", R.drawable.mobilelegend_bloodlustaxe));
        mobilelegend.getItems().add(new ItemGameModel("Athena Shield", "JingShop", "1000", R.drawable.mobilelegend_athenashield));
        mobilelegend.getItems().add(new ItemGameModel("Antique Curasss", "BonShop", "1200", R.drawable.mobilelegend_antiquecurass));
        mobilelegend.getItems().add(new ItemGameModel("Holy Crystal", "LingShop", "800", R.drawable.mobilelegend_holycrystal));
        games.add(mobilelegendRecom);

//        the last of us
        GameItems thelastofusRecom = new GameItems(R.drawable.wallpaper_thelastofus, R.drawable.thelastofus_logo, "The Last of Us", 4.6, "Survival", "recommend");
        thelastofus.getItems().add(new ItemGameModel("Fly Rise Shirt","GonShop","800",R.drawable.thelastofus_flyriseshirt));
        thelastofus.getItems().add(new ItemGameModel("Fire Rise Hoodie","KunShop","800",R.drawable.thelastofus_firerisehoodie));
        thelastofus.getItems().add(new ItemGameModel("Antique Silver","GenShop","1000",R.drawable.thelastofus_antiquesilver));
        games.add(thelastofusRecom);

//        pubg
        GameItems pubgRecom = new GameItems(R.drawable.wallpaper_pubg, R.drawable.pubg_logo, "PUBG", 4.3, "Strategy", "recommend");
        pubg.getItems().add(new ItemGameModel("Black Knight","PopShop","400",R.drawable.pubg_blackknight));
        pubg.getItems().add(new ItemGameModel("Lady of Blood","KoiShop","800",R.drawable.pubg_ladyofblood));
        pubg.getItems().add(new ItemGameModel("Modern Low","BenzShop","1000",R.drawable.pubg_modernlow));
        games.add(pubgRecom);

//        fortnite
        GameItems fortniteRecom = new GameItems(R.drawable.wallpaper_fortnite, R.drawable.fortnite_logo, "Fornite", 3.6, "Action", "recommend");
        fortnite.getItems().add(new ItemGameModel("Finfin Flair","KolShop","600",R.drawable.fortnite_finfinflair));
        fortnite.getItems().add(new ItemGameModel("Brite Star","DolShop","800",R.drawable.fortnite_britestar));
        fortnite.getItems().add(new ItemGameModel("Freshly Forged","TelShop","400",R.drawable.fortnite_freshlyforged));
        fortnite.getItems().add(new ItemGameModel("Brave and Brite","YoonaShop","500",R.drawable.fortnite_braveandbrite));
        fortnite.getItems().add(new ItemGameModel("Pickross Bow","JinShop","1000",R.drawable.fortnite_pickrossbow));
        games.add(fortniteRecom);

//        genshin impact
        GameItems genshinimpactRecom = new GameItems(R.drawable.wallpaper_genshinimpact, R.drawable.genshin_logo, "Genshin Impact", 4.4, "Role-play", "recommend");
        genshinimpact.getItems().add(new ItemGameModel("60 Crystal","FunShop","300",R.drawable.genshin_crystal));
        genshinimpact.getItems().add(new ItemGameModel("300 Crystal","WibuShop","800",R.drawable.genshin_crystal));
        genshinimpact.getItems().add(new ItemGameModel("1000 Crystal","AraShop","1000",R.drawable.genshin_crystal));
        genshinimpact.getItems().add(new ItemGameModel("3000 Crystal","AnaShop","1200",R.drawable.genshin_crystal));
        genshinimpact.getItems().add(new ItemGameModel("6000 Crystal","DollShop","1500",R.drawable.genshin_crystal));
        games.add(genshinimpactRecom);










    }


}
