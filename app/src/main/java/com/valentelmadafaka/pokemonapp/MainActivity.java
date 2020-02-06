package com.valentelmadafaka.pokemonapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.valentelmadafaka.pokemonapp.dataBase.DBInterface;
import com.valentelmadafaka.pokemonapp.model.Pokemon;
import com.valentelmadafaka.pokemonapp.model.PokemonsArray;
import com.valentelmadafaka.pokemonapp.model.Tipo;
import com.valentelmadafaka.pokemonapp.model.TipoDual;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    DBInterface db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = new DBInterface(this);
        db.obre();
        if(db.isPokemonEmpty()){
            for(Pokemon p : inicializarPokemons()){
                String img = "i"+p.getId();
                String imgg = "p"+p.getId();
                p.setImg(img);
                p.setImgg(imgg);
                if (db.insereixPokemon(p.getNombre(), p.getDescripcion(), p.getTipoDual(), p.getTipo(), p.getImg(), p.getImgg(), p.getLinea()) == -1) {
                    Toast.makeText(this, "Error a l’afegir",
                            Toast.LENGTH_SHORT).show();
                }
            }
        }
        if(db.isTiposEmpty()){
            for(Tipo t : inicalizarTipos()){
                if(db.insereixTipus(t.getNombre(), t.getIcon()) == -1){
                    Toast.makeText(this, "Error a l’afegir",
                            Toast.LENGTH_SHORT).show();
                }
            }
        }
        db.tanca();

    }

    public ArrayList<Tipo> inicalizarTipos(){
        ArrayList<Tipo> tipos = new ArrayList<>();

        Tipo bicho = new Tipo("1", "bicho", "t1");
        Tipo siniestro = new Tipo("2", "siniestro", "t2");
        Tipo dragon = new Tipo("3", "dragon", "t3");
        Tipo electrico = new Tipo("4","electrico", "t4");
        Tipo hada = new Tipo("5", "hada", "t5");
        Tipo lucha = new Tipo("6","lucha", "t6");
        Tipo fuego = new Tipo("7", "fuego", "t7");
        Tipo volador = new Tipo("8", "volador", "t8");
        Tipo fantastma = new Tipo("9", "fantasma", "t9");
        Tipo planta = new Tipo("10", "planta", "t10");
        Tipo tierra = new Tipo("11", "tierra", "t11");
        Tipo hielo = new Tipo("12", "hielo", "t12");
        Tipo normal = new Tipo("13","normal", "t13");
        Tipo veneno = new Tipo("14", "veneno", "t14");
        Tipo psiquico = new Tipo("15", "psiquico", "t15");
        Tipo roca = new Tipo("16", "roca", "t16");
        Tipo acero = new Tipo("17", "acero", "t17");
        Tipo agua = new Tipo("18","agua", "t18");

        tipos.add(bicho);
        tipos.add(siniestro);
        tipos.add(dragon);
        tipos.add(electrico);
        tipos.add(hada);
        tipos.add(lucha);
        tipos.add(fuego);
        tipos.add(volador);
        tipos.add(fantastma);
        tipos.add(planta);
        tipos.add(tierra);
        tipos.add(hielo);
        tipos.add(normal);
        tipos.add(veneno);
        tipos.add(psiquico);
        tipos.add(roca);
        tipos.add(acero);
        tipos.add(agua);


        return tipos;
    }


    public ArrayList<Pokemon> inicializarPokemons(){


        Tipo bicho = new Tipo("1", "bicho", "t1");
        Tipo siniestro = new Tipo("2", "siniestro", "t2");
        Tipo dragon = new Tipo("3", "dragon", "t3");
        Tipo electrico = new Tipo("4","electrico", "t4");
        Tipo hada = new Tipo("5", "hada", "t5");
        Tipo lucha = new Tipo("6","lucha", "t6");
        Tipo fuego = new Tipo("7", "fuego", "t7");
        Tipo volador = new Tipo("8", "volador", "t8");
        Tipo fantastma = new Tipo("9", "fantasma", "t9");
        Tipo planta = new Tipo("10", "planta", "t10");
        Tipo tierra = new Tipo("11", "tierra", "t11");
        Tipo hielo = new Tipo("12", "hielo", "t12");
        Tipo normal = new Tipo("13","normal", "t13");
        Tipo veneno = new Tipo("14", "veneno", "t14");
        Tipo psiquico = new Tipo("15", "psiquico", "t15");
        Tipo roca = new Tipo("16", "roca", "t16");
        Tipo acero = new Tipo("17", "acero", "t17");
        Tipo agua = new Tipo("18","agua", "t18");


        ArrayList<Pokemon> pokemons = new ArrayList<>();

        //Primera Generacion

        Pokemon bulbasur = new Pokemon(1, "Bulbasur",
                "Puede sobrevivir largo tiempo sin probar bocado. Guarda energia en el bublo de su espalda.",new TipoDual(planta,veneno), "p1,Nivel 15,p2,Nivel 32,p3");
        pokemons.add(bulbasur);
        Pokemon ivysaur =  new Pokemon(2, "Ivysaur",
                "Su bulbo crece cuando absorbe energía. Desprende un fuerte aroma cuando florece.", new TipoDual(planta,veneno), "p1,Nivel 15,p2,Nivel 32,p3");
        pokemons.add(ivysaur);
        Pokemon venusaur = new Pokemon(3, "Venusaur",
                "La flor de su espalda recoge los rayos del sol. Los transforma en energía.", new TipoDual(planta,veneno), "p1,Nivel 15,p2,Nivel 32,p3");
        pokemons.add(venusaur);
        Pokemon charmander = new Pokemon(4, "Charmander",
                "La llama en la punta de su cola chisporrotea al arder. Sólo se oye en lugares silenciosos.", fuego, "p4,Nivel 16,p5,Nivel 36,p6");
        pokemons.add(charmander);
        Pokemon charmeleon = new Pokemon(5, "Charmeleon",
                "Las duras luchas excitan a este Pokémon. Entonces, lanzará llamaradas blanco-azuladas.", fuego, "p4,Nivel 16,p5,Nivel 36,p6");
        pokemons.add(charmeleon);
        Pokemon charizard = new Pokemon (6, "Charizard",
                "Cuando lanza una descarga de fuego súper caliente, la roja llama de su cola brilla más intensamente.", new TipoDual(fuego,volador), "p4,Nivel 16,p5,Nivel 32,p6");
        pokemons.add(charizard);
        Pokemon squirtle = new Pokemon(7, "Squirtle",
                "Lanza agua a su presa desde el agua. Se esconde en su concha cuando se siente en peligro.", agua, "p7,Nivel 16,p8,Nivel 36,p9");
        pokemons.add(squirtle);
        Pokemon wartortle = new Pokemon(8, "Wartortle",
                "Si es golpeado, esconderá su cabeza. Aun así, su cola puede seguir golpeando.", agua, "p7,Nivel 16,p8,Nivel 36,p9");
        pokemons.add(wartortle);
        Pokemon blastoise = new Pokemon(9, "Blastoise",
                "Cuando ataca a un enemigo, su descarga de agua es aún más potente que una manga de bombero.", agua, "p7,Nivel 16,p8,Nivel 36,p9");
        pokemons.add(blastoise);
        Pokemon caterpie = new Pokemon(10, "Caterpie",
                "Si tocas los receptores de su cabeza, soltará un terrible olor para protegerse.", bicho, "p10,Nivel 7,p11,Nivel 10,p12");
        pokemons.add(caterpie);
        Pokemon metapod = new Pokemon(11, "Metapod",
                "Endurece su concha para protegerse. De todos modos, un gran impacto puede afectarle.", bicho, "p10,Nivel 7,p11,Nivel 10,p12");
        pokemons.add(metapod);
        Pokemon butterfree = new Pokemon(12,"Butterfree",
                "Sus alas están cubiertas de polvos venenosos. Como repelen el agua, puede volar bajo la lluvia.",new TipoDual(bicho, volador), "p10,Nivel 7,p11,Nivel 10,p12");
        pokemons.add(butterfree);
        Pokemon weedle = new Pokemon(13, "Weedle",
                "Cuidado con el aguijón venenoso de su cabeza. Se esconde en la hierba y arbustos mientras come.", new TipoDual(bicho,veneno), "p13,Nivel 7,p14,Nivel 10,p15");
        pokemons.add(weedle);
        Pokemon kakuna = new Pokemon(14,"Kakuna",
                "Sólo puede moverse un poco. Cuando está en peligro, envenena a su enemigo con su aguijón.", new TipoDual(bicho,veneno), "p13,Nivel 7,p14,Nivel 10,p15");
        pokemons.add(kakuna);
        Pokemon beedrill = new Pokemon(15, "Beedrill",
                "Tiene 3 aguijones venenosos en sus patas y cola. Suele pinchar a sus enemigos repetidas veces.", new TipoDual(bicho,veneno), "p13,Nivel 7,p14,Nivel 10,p15");
        pokemons.add(beedrill);
        Pokemon pidgey = new Pokemon(16, "Pidgey",
                "Son muy dóciles. Si son atacados, suelen lanzar arena en lugar de repeler el ataque.", new TipoDual(normal,volador), "p16,Nivel 18,p17,Nivel 36,p18");
        pokemons.add(pidgey);
        Pokemon pidgeotto = new Pokemon(17, "Pidgeotto",
                "Este Pokémon está repleto de vitalidad. Suele volar por su territorio en busca de presas.", new TipoDual(normal,volador), "p16,Nivel 16,p17,Nivel 36,p18");
        pokemons.add(pidgeotto);
        Pokemon pidgeot = new Pokemon(18, "Pidgeot",
                "Este Pokémon vuela a velocidad Mach 2. Sus grandes garras son armas muy peligrosas.", new TipoDual(normal,volador), "p16,Nivel 16,p17,Nivel 36,p18");
        pokemons.add(pidgeot);
        Pokemon rattata = new Pokemon(19, "Rattata",
                "Muerde cualquier cosa con sus colmillos. Si ves uno, seguro que encuentras 40 más en la zona.", normal, "p19,Nivel 20,p20");
        pokemons.add(rattata);
        Pokemon raticate = new Pokemon(20, "Raticate",
                "Sus patas son palmeadas. Sirven de aletas, por lo que puede nadar por ríos en busca de presa.", normal, "p19,Nivel 20,p20");
        pokemons.add(raticate);
        Pokemon spearow = new Pokemon(21,"Spearow",
                "Es incapaz de volar a gran altura, pero es muy rápido, lo que le permite protegerse.", new TipoDual(normal,volador), "p21,Nivel 20,p22");
        pokemons.add(spearow);
        Pokemon fearow = new Pokemon(22, "Fearow",
                "Este Pokémon es conocido desde hace muchos años. Si siente peligro volará lejos inmediatamente.", new TipoDual(normal,volador), "p21,Nivel 20,p22");
        pokemons.add(fearow);
        Pokemon ekans = new Pokemon(23, "Ekans",
                "Cuanto más viejo, más crece este Pokémon. Por la noche, descansa en las ramas de los árboles.", veneno, "p23,Nivel 22,p24");
        pokemons.add(ekans);
        Pokemon arbok = new Pokemon(24,"Arbok",
                "Los espantosos dibujos de su piel han sido estudiados. Seis variaciones han sido confirmadas.", veneno, "p23,Nivel 22,p24");
        pokemons.add(arbok);
        Pokemon pikachu = new Pokemon(25, "Pikachu",
                "Mantiene su cola en alto para vigilar. Si das un tirón a su cola, querrá morderte.", electrico, "p172,Amistad + subir un nivel,p25,Piedra Trueno,p26");
        pokemons.add(pikachu);
        Pokemon raichu = new Pokemon(26, "Raichu",
                "Cuando la electricidad del cuerpo crece, se vuelve irritable. También brilla en la oscuridad.", electrico, "p172,Amistad + subir un nivel,p25,Piedra Trueno,p26");
        pokemons.add(raichu);
        Pokemon sandshrew = new Pokemon(27, "Sandshrew",
                "Su cuerpo es muy seco. Cuando hace frío por la noche, su piel aparece cubierta con un fino rocío.", tierra, "p27,Nivel 22,p28");
        pokemons.add(sandshrew);
        Pokemon sandslash = new Pokemon(28, "Sandslash",
                "Es muy hábil al golpear a sus enemigos con sus garras. Si se rompen, crecerán en un solo día.", tierra, "p27,Nivel 22,p28");
        pokemons.add(sandslash);
        Pokemon nidoranH = new Pokemon(29, "Nidoran♀",
                "A este Pokémon no le gusta luchar. Pero cuidado, sus pequeños cuernos segregan veneno.", veneno, "p29,Nivel 16,p30,Piedra Lunar,p31");
        pokemons.add(nidoranH);
        Pokemon nidorina = new Pokemon(30, "Nidorina",
                "Cuando descansa profundamente, sus cuernos se contraen. Esto prueba que está relajado", veneno, "p29,Nivel 16,p30,Piedra Lunar,p31");
        pokemons.add(nidorina);
        Pokemon nidoqueen = new Pokemon(31, "Nidoqueen",
                "Grandes escamas recubren el duro cuerpo de este Pokémon. Éstas crecen cíclicamente.", new TipoDual(veneno, tierra), "p29,Nivel 16,p30,Piedra Lunar,p31");
        pokemons.add(nidoqueen);
        Pokemon nidoranM = new Pokemon(32, "Nidoran♂",
                "Sus largas orejas se mantienen siempre alerta. Si siente peligro, atacará con su venenoso cuerno.", veneno, "p32,Nivel 16,p33,Piedra Lunar,p34");
        pokemons.add(nidoranH);
        Pokemon nidorino = new Pokemon(33,"Nidorino",
                "Sus cuernos contienen veneno. Si se introducen en el cuerpo del enemigo, soltarán su tóxica carga.", veneno, "p32,Nivel 16,p33,Piedra Lunar,p34");
        pokemons.add(nidorino);
        Pokemon nidoking = new Pokemon(34, "Nidoking",
                "Duro como el acero, posee una poderosa carga. Sus cuernos son tan duros como el diamante.", new TipoDual(veneno,tierra), "p32,Nivel 16,p33,Piedra Lunar,p34");
        pokemons.add(nidoking);
        Pokemon clefairy = new Pokemon(35, "Clefairy",
                "Su aspecto jovial y vivaracho lo hace adorable. Piensan que son raros, ya que no son muy comunes.", hada, "p173,Amistad + Subir un nivel,p35,Piedra Lunar,p36");
        pokemons.add(clefairy);
        Pokemon clefable = new Pokemon(36, "Clefable",
                "Protege bastante bien su propio entorno. Es una especie de hada, raramente vista por los humanos.", hada, "p173,Amistad + Subir un nivel,p35,Piedra Lunar,p36");
        pokemons.add(clefable);
        Pokemon vulpix = new Pokemon(37, "Vulpix",
                "Su piel y colas son preciosas. Cuando crecen las colas, se dividen formando nuevas colas.", fuego, "p37,Piedra Fuego,p38");
        pokemons.add(vulpix);
        Pokemon ninetales = new Pokemon(38, "Ninetales",
                "De acuerdo con una antigua leyenda, este Pokémon es la reencarnación de 9 nobles santos.", fuego, "p37,Piedra Fuego,p38");
        pokemons.add(ninetales);
        Pokemon jigglypuff = new Pokemon(39, "Jigglypuff",
                "Utiliza sus misteriosos ojos para engañar a su enemigo. También cantará para dormirlo.", new TipoDual(normal,hada), "p174,Amistad + Subir un nivel,p39,Piedra Lunar,p40");
        pokemons.add(jigglypuff);
        Pokemon wigglytuff = new Pokemon(40, "Wigglytuff",
                "Su cuerpo es muy elástico. Cuando inhala aire profundamente, puede inflarse sin límite.", new TipoDual(normal,hada), "p174,Amistad + Subir un nivel,p39,Piedra Lunar,p40");
        pokemons.add(wigglytuff);
        Pokemon zubat = new Pokemon(41, "Zubat",
                "Emite sonidos ultrasónicos mientras vuela. Los utiliza como sónar para evitar obstáculos.", new TipoDual(veneno, volador), "p41,Nivel 22,p42,Amistad + Subier un nivel,p169");
        pokemons.add(zubat);
        Pokemon golbat = new Pokemon(42, "Golbat",
                "Ataca de manera violenta sin avisar. Utiliza sus afilados colmillos para chupar sangre.", new TipoDual(veneno,volador), "p41,Nivel 22,p42,Amistad + Subier un nivel,p169");
        pokemons.add(golbat);
        Pokemon oddish = new Pokemon(43, "Oddish",
                "Suele ser confundido con un puñado de semillas. Si lo extraes del suelo, gritará.", new TipoDual(planta,veneno), "p43,Nivel 21,p44,Piedra hoja,p45,odd,Piedra solar,p182");
        pokemons.add(oddish);
        Pokemon glooom = new Pokemon(44, "Gloom",
                "¡Huele bastante mal! De todas formas, 1 de cada 1000 personas aprecian su fétido olor.", new TipoDual(planta,veneno), "p43,Nivel 21,p44,Piedra hoja,p45,odd,Piedra solar,p182");
        pokemons.add(glooom);
        Pokemon vileplume = new Pokemon(45, "Vileplume",
                "Aletea sus pétalos de flores para propagar su venenoso polen. El sonido que emite es agudo.", new TipoDual(planta,veneno), "p43,Nivel 21,p44,Piedra hoja,p45,odd,Piedra solar,p182");
        pokemons.add(vileplume);
        Pokemon paras = new Pokemon(46, "Paras",
                "Escarba bajo el suelo para roer las raíces de los árboles. Sus setas absorben sus energías.", new TipoDual(bicho,planta), "p46,Nivel 24,p47");
        pokemons.add(paras);
        Pokemon parasect = new Pokemon(47, "Parasect",
                "El parásito absorbe la energía con las setas de la espalda, que lo controlan.", new TipoDual(bicho,planta), "p46,Nivel 24,p47");
        pokemons.add(parasect);
        Pokemon venonat = new Pokemon(48, "Venonat",
                "Sus grandes ojos actúan como radares. En lugares claros, verás montones de pequeños ojos.", new TipoDual(bicho,veneno), "p48,Nivel 31,p49");
        pokemons.add(venonat);
        Pokemon venomoth = new Pokemon(49, "Venomoth",
                "Es difícil quitar el polvo de sus alas. También posee un veneno que se desprende al contacto.", new TipoDual(bicho,veneno), "p48,Nivel 31,p49");
        pokemons.add(venomoth);
        Pokemon diglett = new Pokemon(50, "Diglett",
                "Prefiere los lugares oscuros. Pasa el tiempo bajo tierra, aunque aparece en cuevas.", tierra, "p50,Nivel 26,p51");
        pokemons.add(diglett);
        Pokemon dugtrio = new Pokemon(51, "Dugtrio",
                "Un grupo de trillizos que cava a 90 KPH. Por ello, creen que se trata de un terremoto.", tierra, "p50,Nivel 26,p51");
        pokemons.add(dugtrio);
        Pokemon meowth = new Pokemon(52,"Meowth",
                "Parece que son más activos por la noche. Adoran las cosas redondas y brillantes.", normal, "p52,Nivel 28,p53");
        pokemons.add(meowth);
        Pokemon persian = new Pokemon(53, "Persian",
                "¡La gema en su frente brilla por sí misma! Camina con la elegancia de una reina.", normal, "p52,Nivel 28,p53");
        pokemons.add(persian);
        Pokemon psyduck = new Pokemon(54, "Psyduck",
                "Siempre tiene dolores de cabeza. Posee poderes mentales, pero no sabes cuándo los usará.", agua, "p54,Nivel 33,p55");
        pokemons.add(psyduck);
        Pokemon golduck = new Pokemon(55, "Golduck",
                "Sus delgados y largos miembros acaban en anchas aletas. Las usan para nadar en los lagos.", agua, "p54,Nivel 33,p55");
        pokemons.add(golduck);
        Pokemon mankey = new Pokemon(56, "Mankey",
                "Este ágil Pokémon vive en los arboles. Se enfada fácilmente y no dudará en atacar a todos.", lucha, "p56,Nivel 28,p57");
        pokemons.add(mankey);
        Pokemon primeapoe = new Pokemon(57,"Primeape",
                "Sólo se calma cuando nadie está cerca. Llegar a ver ese momento es realmente difícil.", lucha, "p56,Nivel 28,p57");
        pokemons.add(primeapoe);
        Pokemon growlithe = new Pokemon(58, "Growlithe",
                "Este Pokémon es muy amistoso. Aun así, gruñirá a cualquiera que invada su territorio.", fuego, "p58,Piedra Fuego,p59");
        pokemons.add(growlithe);
        Pokemon arcanine = new Pokemon(59,"Arcanine",
                "Es un Pokémon legendario en China. Allí, adoran la gracia y belleza que exhibe al correr.", fuego, "p58,Piedra Fuego,p59");
        pokemons.add(arcanine);
        Pokemon poliwag = new Pokemon(60, "Poliwag",
                "La dirección de la espiral en el vientre cambia según el área. Prefiere nadar a correr.", agua, "p60,Nivel 25,p61,Piedra Agua,p62,odd,Intercambio con Roca del rey,p186");
        pokemons.add(poliwag);
        Pokemon poliwhirl = new Pokemon(61, "Poliwhirl",
                "Cuando lo atacan, usa la espiral del vientre para dormir al rival. Aprovecha para escapar entonces.", agua, "p60,Nivel 25,p61,Piedra Agua,p62,odd,Intercambio con Roca del rey,p186");
        pokemons.add(poliwhirl);
        Pokemon poliwrath = new Pokemon(62, "Poliwrath",
                "Es capaz de nadar usando todos los músculos de su cuerpo. Podrá adelantar incluso a un campeón.", new TipoDual(agua,lucha), "p60,Nivel 25,p61,Piedra Agua,p62,odd,Intercambio con Roca del rey,p186");
        pokemons.add(poliwrath);
        Pokemon abra = new Pokemon(63, "Abra",
                "Duerme 18 horas al día. Si siente peligro, se teletransporta a un lugar seguro, aun durmiendo.", psiquico, "p63,Nivel 16,p64,Intercambio,p65");
        pokemons.add(abra);
        Pokemon kadabra = new Pokemon(64, "Kadabra",
                "Muchas cosas raras suceden si está cerca. Por ejemplo, hace que los relojes vayan al revés.", psiquico, "p63,Nivel 16,p64,Intercambio,p65");
        pokemons.add(kadabra);
        Pokemon alakazam = new Pokemon(65, "Alakazam",
                "Este Pokémon lo recuerda todo. Nunca olvida lo que aprende. Es un Pokémon muy listo.", psiquico, "p63,Nivel 16,p64,Intercambio,p65");
        pokemons.add(alakazam);
        Pokemon machop = new Pokemon(66, "Machop",
                "Muy poderoso a pesar de su pequeño tamaño. Su maestría en artes marciales lo hace muy duro.", lucha, "p66,Nivel 28,p67,Intercambio,p68");
        pokemons.add(machop);
        Pokemon machoke = new Pokemon(67, "Machoke",
                "El cinturón que rodea su cintura retiene toda su energía. Sin él, este Pokémon sería implacable.", lucha, "p66,Nivel 28,p67,Intercambio,p68");
        pokemons.add(machoke);
        Pokemon machamp = new Pokemon(68,"Machamp",
                "Con sólo un brazo puede mover montañas. Usando los cuatro, este Pokémon puede ser terrible.", lucha, "p66,Nivel 28,p67,Intercambio,p68");
        pokemons.add(machamp);
        Pokemon bellsprout = new Pokemon(69, "Bellsprout",
                "Prefiere los lugares calientes y húmedos. Atrapa pequeños insectos con sus ramas para devorarlos.", new TipoDual(planta,veneno), "p69,Nivel 21,p70,Piedra hoja,p71");
        pokemons.add(bellsprout);
        Pokemon weepinbell = new Pokemon(70,"Weepinbell",
                "Cuando está hambriento, ataca a todo lo que se mueva. Su pobre presa se derrite en fuertes ácidos.", new TipoDual(planta,veneno), "p69,Nivel 21,p70,Piedra hoja,p71");
        pokemons.add(weepinbell);
        Pokemon victreebel = new Pokemon(71, "Victreebel",
                "Engaña a su presa con un dulce aroma a miel. Una vez atrapada, la presa perderá hasta sus huesos.", new TipoDual(planta,veneno), "p69,Nivel 21,p70,Piedra hoja,p71");
        pokemons.add(victreebel);
        Pokemon tentacool = new Pokemon(72,"Tentacool",
                "A veces puede ser encontrado seco y medio enterrado en una playa. Al lanzarlo otra vez al mar revivirá.", new TipoDual(agua,veneno), "p72,Nivel 30,p73");
        pokemons.add(tentacool);
        Pokemon tentacruel = new Pokemon(73, "Tentacruel",
                "Puede controlar libremente sus 80 tentáculos. Éstos debilitan a la presa con su poderoso veneno.", new TipoDual(agua,veneno), "p72,Nivel 30,p73");
        pokemons.add(tentacruel);
        Pokemon geodude = new Pokemon(74,"Geodude",
                "Se encuentran normalmente en los caminos de montaña. Si te cruzas con uno, se enfadará.", new TipoDual(roca,tierra), "p74,Nivel 25,p75,Intercambio,p76");
        pokemons.add(geodude);
        Pokemon graveler = new Pokemon(75,"Graveler",
                "Se le suele ver rodando por las montañas. Los obstáculos no los evita. ¡Los arrolla!", new TipoDual(roca,tierra), "p74,Nivel 25,p75,Intercambio,p76");
        pokemons.add(graveler);
        Pokemon golem = new Pokemon(76,"Golem",
                "Cuando pierde su piel, su cuerpo se vuelve blando y blanquecino. Si esto ocurre, se esconderá.", new TipoDual(roca,tierra), "p74,Nivel 25,p75,Intercambio,p76");
        pokemons.add(golem);
        Pokemon ponyta = new Pokemon(77, "Ponyta",
                "Es capaz de saltar muy alto. Con sus pezuñas y sus robustas patas, absorbe el impacto.", fuego, "p77,Nivel 40,p78");
        pokemons.add(ponyta);
        Pokemon rapidash = new Pokemon(78,"Rapidash",
                "Le encanta correr. Si ve algo más rápido que él, intentará alcanzarlo a toda velocidad.", fuego, "p77,Nivel 40,p78");
        pokemons.add(rapidash);
        Pokemon slowpoke = new Pokemon(79, "Slowpoke",
                "Es increíblemente lento y perezoso. Le encanta dormir sin preocuparse ni del tiempo ni de lo que ocurra.", new TipoDual(agua, psiquico), "p79,Nivel 37,p80,Intercambio con roca del rey,p199,slow");
        pokemons.add(slowpoke);
        Pokemon slowbro = new Pokemon(80, "Slowbro",
                "Vive tranquilo en el mar. Si el Shellder de su cola se cae, vuelve a ser un Slowpoke otra vez.", new TipoDual(agua,psiquico), "p79,Nivel 37,p80,Intercambio con roca del rey,p199,slow");
        pokemons.add(slowbro);
        Pokemon magnemite = new Pokemon(81, "Magnemite",
                "Puede desafiar a la gravedad desde su nacimiento. Flota en el aire gracias a ondas electromagnéticas.", new TipoDual(electrico,acero), "p81,Nivel 30,p82");
        pokemons.add(magnemite);
        Pokemon magneton = new Pokemon(82, "Magneton",
                "Genera extrañas señales de radio. Es capaz de elevar la temperatura 3º centígrados.", new TipoDual(electrico,acero), "p81,Nivel 30,p82");
        pokemons.add(magneton);
        Pokemon farfetchd = new Pokemon(83, "Farfetch'd",
                "Vive cerca de las plantas. Son raramente vistos, así que se piensa que se están extinguiendo.", new TipoDual(normal,volador), "p83");
        pokemons.add(farfetchd);
        Pokemon doduo = new Pokemon(84, "Doduo",
                "Sus cortas alas lo hacen volar con dificultad. De todos modos, puede correr a gran velocidad.", new TipoDual(normal,volador), "p84,Nivel 31,p85");
        pokemons.add(doduo);
        Pokemon dodrio = new Pokemon(85, "Dodrio",
                "Una de las dos cabezas de Doduo se divide para formar un nuevo PkMn. Es capaz de correr a 40 KPH.", new TipoDual(normal,volador), "p84,Nivel 31,p85");
        pokemons.add(dodrio);
        Pokemon seel = new Pokemon(86, "Seel",
                "A este Pokémon le encanta el frío. Le encanta nadar en climas polares, sea cual sea la temperatura.", agua, "p86,Nivel 34,p87");
        pokemons.add(seel);
        Pokemon dewgong = new Pokemon(87, "Dewgong",
                "Su cuerpo es como una bola de nieve. Inmune al frío intenso, nada rápidamente en aguas heladas.", new TipoDual(agua, hielo), "p86,Nivel 34,p87");
        pokemons.add(dewgong);
        Pokemon grimer = new Pokemon(88, "Grimer",
                "Está hecho de fango endurecido. Huele a pútrido. ¡Por donde pasa, no crece la hierba!", veneno, "p88,Nivel 38,p89");
        pokemons.add(grimer);
        Pokemon muk = new Pokemon(89, "Muk",
                "Huele tan mal que puede provocar desmayos. Ha degenerado tanto, que ya ni él mismo se huele.", veneno, "p88,Nivel 38,p89");
        pokemons.add(muk);
        Pokemon shellder = new Pokemon(90, "Shellder",
                "Su concha puede evitar cualquier ataque. El débil cuerpo sólo está expuesto cuando está abierta.", agua, "p90,Piedra agua,p91");
        pokemons.add(shellder);
        Pokemon cloyster = new Pokemon(91,"Cloyster",
                "Utiliza su concha para protegerse. Dicen que es más dura que el diamante. También lanza espinas.", new TipoDual(agua,hielo), "p90,Piedra agua,p91");
        pokemons.add(cloyster);
        Pokemon gastly = new Pokemon(92,"Gastly",
                "Solo aparece en edificios en ruinas. No tiene forma real, ya que parece que está hecho de gas.", new TipoDual(fantastma,veneno), "p92,Nivel 25,p93,Intercambio,p94");
        pokemons.add(gastly);
        Pokemon haunter = new Pokemon(93,"Haunter",
                "Toma la vida de su adversario a lengüetazos. Esto produce mareos hasta que la víctima fallece.", new TipoDual(fantastma,veneno), "p92,Nivel 25,p93,Intercambio,p94");
        pokemons.add(haunter);
        Pokemon gengar = new Pokemon(94,"Gengar",
                "Sabrás que un Gengar está cerca cuando sufras de sudores fríos. Intentará echarte un hechizo.", new TipoDual(fantastma,veneno), "p92,Nivel 25,p93,Intercambio,p94");
        pokemons.add(gengar);
        Pokemon onix = new Pokemon(95,"Onix",
                "Cava a gran velocidad en busca de comida. Los túneles que deja son usados por los Diglett.", new TipoDual(roca,tierra), "p95,Intercambio con Rev.metalico,p208");
        pokemons.add(onix);
        Pokemon drowzee = new Pokemon(96,"Drowzee",
                "Si duermes cerca de uno todo el tiempo, en alguna ocasión podrás ver sueños que se haya comido antes.", psiquico, "p96,Nivel 26,p97");
        pokemons.add(drowzee);
        Pokemon hypno = new Pokemon(97,"Hypno",
                "Intenta evitar cualquier tipo de contacto visual con este Pokémon. Puede hipnotizar con su péndulo.", psiquico, "p96,Nivel 26,p97");
        pokemons.add(hypno);
        Pokemon krabby = new Pokemon(98,"Krabby",
                "Sus pinzas son armas perfectas. En alguna ocasión pueden romperse en combate, pero crecerán rápido.", agua, "p98,Nivel 28,p99");
        pokemons.add(krabby);
        Pokemon klinger = new Pokemon(99,"Klinger",
                "Una de sus pinzas crece más que la otra, y es dura como el acero. De todos modos, pesa demasiado.", agua, "p98,Nivel 28,p99");
        pokemons.add(klinger);
        Pokemon voltorb = new Pokemon(100,"Voltorb",
                "Se dice que se camufla como una Poké Ball. Al más mínimo estímulo se autodestruirá.", electrico, "p100,Nivel 30,p101");
        pokemons.add(voltorb);
        Pokemon electrode = new Pokemon(101,"Electrode",
                "Almacena energía eléctrica en su cuerpo. El más leve shock puede provocar una gran explosión.",electrico, "p100,Nivel 30,p101");
        pokemons.add(electrode);
        Pokemon exeggcute = new Pokemon(102,"Exeggcute",
                "Sus cabezas se atraen unas a otras, y giran entre sí. Debe tener seis para equilibrarse.", new TipoDual(planta,psiquico), "p102,Piedra hoja,p103");
        pokemons.add(exeggcute);
        Pokemon exeggutor = new Pokemon(103,"Exeggutor",
                "Este Pokémon es muy ruidoso. Esto es debido a que cada una de sus cabezas hace lo que quiere.", new TipoDual(planta,psiquico), "p102,Piedra hoja,p103");
        pokemons.add(exeggutor);
        Pokemon cubone = new Pokemon(104,"Cubone",
                "Siempre lleva el cráneo de su difunta madre. Su grito hace eco y parece una triste melodía.", tierra, "p104,Nivel 28,p105");
        pokemons.add(cubone);
        Pokemon marowak = new Pokemon(105,"Marowak",
                "Pequeño y débil, este Pokémon siempre va acompañado de su palo de hueso de Pokémon.", tierra, "p104,Nivel 28,p105");
        pokemons.add(marowak);
        Pokemon hitmonlee = new Pokemon(106,"Hitmonlee",
                "Cuando da patadas al enemigo, la planta de sus pies se vuelve tan dura como el diamante.", lucha, "p236,Nivel 20 Ataque > Defensa,p106,Nivel 20 Ataque < Defensa,p107,tyr,Nivel 20 Ataque = Defensa,p237");
        pokemons.add(hitmonlee);
        Pokemon hitmonchan = new Pokemon(107,"Hitmonchan",
                "Sus golpes se asemejan a una taladradora. Puede atravesar un muro de hormigón como si nada.", lucha, "p236,Nivel 20 Ataque > Defensa,p106,Nivel 20 Ataque < Defensa,p107,tyr,Nivel 20 Ataque = Defensa,p237");
        pokemons.add(hitmonchan);
        Pokemon lickitung = new Pokemon(108,"Lickitung",
                "Su lengua mide casi dos metros y se mueve libremente. Sus lametazos pueden causar parálisis.", normal, "p108");
        pokemons.add(lickitung);
        Pokemon koffing = new Pokemon(109,"Koffing",
                "A veces puede explotar sin avisar, ya que en lugares calurosos su gas interno se expande.", veneno, "p109,Nivel 35,p110");
        pokemons.add(koffing);
        Pokemon weezing = new Pokemon(110,"Weezing",
                "Este Pokémon vive absorbiendo gases venenosos, gérmenes, y el polvo que existe en la basura.", veneno, "p109,Nivel 35,p110");
        pokemons.add(weezing);
        Pokemon rhyhorn = new Pokemon(111,"Rhyhorn",
                "Este Pokémon no tiene muchas luces. Una vez inicia la carga, no para hasta que cae dormido.", new TipoDual(tierra,roca), "p111,Nivel 42,p112");
        pokemons.add(rhyhorn);
        Pokemon rhydon = new Pokemon(112,"Rhydon",
                "Camina sobre sus patas traseras, y muestra signos de inteligencia. Es capaz de aguantar lava hirviendo.", new TipoDual(tierra,roca), "p111,Nivel 42,p112");
        pokemons.add(rhydon);
        Pokemon chansey = new Pokemon(113,"Chansey",
                "Este amable Pokémon es capaz de compartir sus nutrientes huevos con un Pokémon herido.", normal, "p113,Amistad + subir un nivel,p242");
        pokemons.add(chansey);
        Pokemon tangela = new Pokemon(114,"Tangela",
                "Se camufla tras una gran masa de enredaderas azules. Se dice que nunca dejan de crecer.", planta, "p114");
        pokemons.add(tangela);
        Pokemon kangaskhan = new Pokemon(115,"Kangaskhan",
                "Cuida de su cría en la bolsa de su tripa. No evitará ninguna pelea para protegerla.", normal, "p115");
        pokemons.add(kangaskhan);
        Pokemon horsea = new Pokemon(116,"Horsea",
                "Si se siente en peligro, arrojará un potente chorro de agua, o de una tinta especial, por su boca.", agua, "p116,Nivel 32,p117,Intecambio con Escamadragon,p230");
        pokemons.add(horsea);
        Pokemon seadra = new Pokemon(117,"Seadra",
                "Tocar su aleta trasera causa parálisis. Se engancha al coral para mantenerse mientras duerme.", agua, "p116,Nivel 32,p117,Intecambio con Escamadragon,p230");
        pokemons.add(seadra);
        Pokemon goldeen = new Pokemon(118,"Goldeen",
                "En su época de puesta de huevos, suelen ser vistos nadando por ríos contracorriente en grandes grupos.", agua, "p118,Nivel 33,p119");
        pokemons.add(goldeen);
        Pokemon seaking = new Pokemon(119,"Seaking",
                "Este Pokémon hace sus nidos tallando cantos de riachuelo con el cuerno de su cabeza.", agua, "p118,Nivel 33,p119");
        pokemons.add(seaking);
        Pokemon staryu = new Pokemon(120,"Staryu",
                "Mientras Su parte central se mantenga intacta, crecerá de nuevo aunque haya sido destrozado.", agua, "p120,Piedra Agua,p121");
        pokemons.add(staryu);
        Pokemon starmie = new Pokemon(121,"Starmie",
                "Su zona central es conocida como el núcleo. Se piensa que se comunica mediante colores", new TipoDual(agua,psiquico), "p120,Piedra Agua,p121");
        pokemons.add(starmie);
        Pokemon mr_mime = new Pokemon(122,"Mr.Mime",
                "Siempre practica la misma pantomima. Hace creer al enemigo que existe algo que no es real.", new TipoDual(psiquico,hada), "p122");
        pokemons.add(mr_mime);
        Pokemon scyther = new Pokemon(123,"Scyther",
                "Se agazapa en la hierba alta para saltar sobre su enemigo con sus guadañas. Se mueve como un ninja.", new TipoDual(bicho,volador), "p123,Intercambio con Rev. metalico,p212");
        pokemons.add(scyther);
        Pokemon jynx = new Pokemon(124,"Jynx",
                "Parece moverse como si estuviera bailando un ritmo de su propia creación. Menea mucho sus caderas.", new TipoDual(hielo,psiquico), "p238,Nivel 30,p124");
        pokemons.add(jynx);
        Pokemon electabuzz = new Pokemon(125,"Electabuzz",
                "Cuando hay un apagón, es más que posible que este Pokémon se haya comido la energía.", electrico, "p239,Nivel 30,p125");
        pokemons.add(electabuzz);
        Pokemon magmar = new Pokemon(126,"Magmar",
                "Nacen en volcanes activos. Su cuerpo parece una gran bola de fuego ya que están en llamas.", fuego, "p240,Nivel 30,p126");
        pokemons.add(magmar);
        Pokemon pinsir = new Pokemon(127,"Pinsir",
                "Atrapa a su presa con sus pinzas, y aprieta fuerte. No se puede mover si hace mucho frío.", bicho, "p127");
        pokemons.add(pinsir);
        Pokemon tauros = new Pokemon(128,"Tauros",
                "Un rudo Pokémon repleto de energía vital. Cuando corre, no para hasta que choca con algo.", normal, "p128");
        pokemons.add(tauros);
        Pokemon magikarp = new Pokemon(129,"Magikarp",
                "Famoso por ser poco fiable. Puede encontrarse nadando en mares, lagos, ríos y charcos", agua, "p129,Nivel 20,p130");
        pokemons.add(magikarp);
        Pokemon gyarados = new Pokemon(130,"Gyarados",
                "Este Pokémon es enormemente destructivo. En la antigüedad, era conocido por destruir ciudades.", new TipoDual(agua,volador), "p129,Nivel 20,p130");
        pokemons.add(gyarados);
        Pokemon lapras = new Pokemon(131,"Lapras",
                "PEste espíritu gentil es capaz de leer la mente. Puede llevar a la gente a través del mar.", new TipoDual(agua,hielo), "p131");
        pokemons.add(lapras);
        Pokemon ditto = new Pokemon(132,"Ditto",
                "Cuando se fija en un enemigo, su cuerpo se transforma en una copia perfecta del mismo.", normal, "p132");
        pokemons.add(ditto);
        Pokemon eevee = new Pokemon(133,"Eevee",
                "Su código genético es muy inestable. Puede evolucionar en diversas razas de Pokémon.", normal, "p133,Piedra agua,p134,Piedra trueno,p135,eve,Piedra fuego,p136,Amistad + subir nivel(dia),p196,Amistad + subir nivel(noche),p197");
        pokemons.add(eevee);
        Pokemon vaporeon = new Pokemon(134,"Vaporeon",
                "Su estructura celular se parece a las moléculas de agua. Es invisible cuando está en el agua", agua, "p133,Piedra agua,p134,Piedra trueno,p135,eve,Piedra fuego,p136,Amistad + subir nivel(dia),p196,Amistad + subir nivel(noche),p197");
        pokemons.add(vaporeon);
        Pokemon jolteon = new Pokemon(135,"Jolteon",
                "Un Pokémon muy sensible. Se entristece o enfada con mucha facilidad, lo que le da energía.", electrico, "p133,Piedra agua,p134,Piedra trueno,p135,eve,Piedra fuego,p136,Amistad + subir nivel(dia),p196,Amistad + subir nivel(noche),p197");
        pokemons.add(jolteon);
        Pokemon flareon = new Pokemon(136,"Flareon",
                "El cuerpo de este Pokémon posee una cámara ígnea. Cuando exhala aire, éste está a 3.000º Celsius.", fuego, "p133,Piedra agua,p134,Piedra trueno,p135,eve,Piedra fuego,p136,Amistad + subir nivel(dia),p196,Amistad + subir nivel(noche),p197");
        pokemons.add(flareon);
        Pokemon porygon = new Pokemon(137,"Porygon",
                "La gente dice que se trata del único Pokémon que puede volar por el espacio. Aún no lo ha logrado.", normal, "p137,Intercambio con Mejora,p233");
        pokemons.add(porygon);
        Pokemon omanyte = new Pokemon(138,"Omanyte",
                "Este antiguo Pokémon fue recuperado de un fósil. Nada muy bien gracias al movimiento de sus 10 tentáculos.", new TipoDual(roca,agua), "p138,Nivel 40,p139");
        pokemons.add(omanyte);
        Pokemon omastar = new Pokemon(139,"Omastar",
                "Picos afilados rodean su boca.Su concha es demasiado grande como para que se mueva libremente.", new TipoDual(roca,agua), "p138,Nivel 40,p139");
        pokemons.add(omastar);
        Pokemon kabuto = new Pokemon(140,"Kabuto",
                "Este Pokémon fue recuperado desde un fósil. Usa los ojos de su espalda al ocultarse en el lecho marino.", new TipoDual(roca,agua), "p140,Nivel 40,p141");
        pokemons.add(kabuto);
        Pokemon kabutops = new Pokemon(141,"Kabutops",
                "Este Pokémon es un hábil y rápido nadador. Atrapa a su presa para drenar sus fluidos vitales.", new TipoDual(roca,agua), "p140,Nivel 40,p141");
        pokemons.add(kabutops);
        Pokemon aerodactyl = new Pokemon(142,"Aerodactyl",
                "Este Pokémon salvaje, extinto hace siglos, fue resucitado usando ADN tomado de un ámbar.", new TipoDual(roca,volador), "p142");
        pokemons.add(aerodactyl);
        Pokemon snorlax = new Pokemon(143,"Snorlax",
                "Come cualquier cosa. Incluso la comida pasada de fecha. Su estómago nunca se llena.", normal, "p143");
        pokemons.add(snorlax);
        Pokemon articuno = new Pokemon(144,"Articuno",
                "Un legendario pájaro Pokémon. Congela el agua que encuentra en el aire para generar nieve.", new TipoDual(hielo,volador), "p144");
        pokemons.add(articuno);
        Pokemon zapdos = new Pokemon(145,"Zapdos",
                "ste legendario pájaro Pokémon sólo aparece cuando el cielo se torna oscuro y caen rayos.", new TipoDual(electrico,volador), "p145");
        pokemons.add(zapdos);
        Pokemon moltres = new Pokemon(146,"Moltres",
                "Un legendario pájaro Pokémon. Cuando aletea sus flamígeras alas, la oscura noche se torna roja.", new TipoDual(fuego,volador), "p146");
        pokemons.add(moltres);
        Pokemon dratini = new Pokemon(147,"Dratini",
                "La existencia de este Pokémon ha sido confirmada recientemente por un pescador que cogió uno.", dragon, "p147,Nivel 30,p148,Nivel 55,p149");
        pokemons.add(dratini);
        Pokemon dragonair = new Pokemon(148,"Dragonair",
                "De acuerdo con un testigo, un aura de extraña forma lo rodea, dándole un misterioso y místico aspecto.", dragon, "p147,Nivel 30,p148,Nivel 55,p149");
        pokemons.add(dragonair);
        Pokemon dragonite = new Pokemon(149,"Dragonite",
                "Se dice que este Pokémon vive en algún lugar del mar, y que vuela. De todos modos, sólo es un rumor.", new TipoDual(dragon,volador), "p147,Nivel 30,p148,Nivel 55,p149");
        pokemons.add(dragonite);
        Pokemon mewtwo = new Pokemon(150,"MewTwo",
                "Su ADN es casi el mismo que el de Mew. De todos modos, su tamaño y disposición son diferentes.", psiquico, "p150");
        pokemons.add(mewtwo);
        Pokemon mew = new Pokemon(151,"Mew",
                "Cuando es mirado a través de un microscopio, puede observarse el delicado pelo de este Pokémon.", psiquico, "p151");
        pokemons.add(mew);

        //Segunda generacion

        Pokemon chikorita = new Pokemon(152, "Chikorita",
                "Al luchar, Chikorita agita la hoja que tiene para mantener a raya al rival. Pero, al mismo tiempo, libera una suave fragancia que apacigua el encuentro y crea un ambiente agradable y de amistad.", planta, "p152,Nivel 16,p153,Nivel 32,p154");
        pokemons.add(chikorita);
        Pokemon bayleef = new Pokemon(153, "Bayleef",
                "Bayleef tiene un collar de hojas alrededor del cuello y un brote de un árbol en cada una de ellas. La fragancia que desprenden estos brotes anima a la gente.", planta, "p152,Nivel 16,p153,Nivel 32,p154");
        pokemons.add(bayleef);
        Pokemon meganium = new Pokemon(154, "Meganium",
                "La fragancia de la flor de Meganium aplaca y suaviza los ánimos. Al luchar, este Pokémon libera mayor cantidad de esencia para disminuir el ánimo de combate de su oponente.", planta, "p152,Nivel 16,p153,Nivel 32,p154");
        pokemons.add(meganium);
        Pokemon cyndaquil = new Pokemon(155, "Cyndaquil",
                "Cyndaquil se protege soltando llamas por el lomo. Cuando está enfadado, las llamas son fieras, pero, si está cansado, solo consigue echar algunas chispas que no llegan a cuajar en una completa combustión.", fuego, "p155,Nivel 14,p156,Nivel 36,p157");
        pokemons.add(cyndaquil);
        Pokemon quilava = new Pokemon(156, "Quilava",
                "Quilava mantiene a sus rivales a raya con la intensidad de sus llamas y las ráfagas de aire ígneo que producen. También aprovecha su espectacular agilidad para esquivar ataques a la vez que abrasa al rival con sus llamas.", fuego, "p155,Nivel 14,p156,Nivel 36,p157");
        pokemons.add(quilava);
        Pokemon typhlosion = new Pokemon(157, "Typhlosion",
                "Typhlosion se oculta tras un trémulo haz de calor que crea mediante sus intensas y sofocantes llamaradas. Este Pokémon causa explosiones de fuego que reducen todo a cenizas.", fuego, "p155,Nivel 14,p156,Nivel 36,p157");
        pokemons.add(typhlosion);
        Pokemon totodile = new Pokemon(158, "Totodile",
                "Totodile tiene cuerpo pequeño, pero fuertes mandíbulas. A veces, piensa que solo está dando un mordisquito y hace unas heridas bastante considerables.", agua, "p158,Nivel 18,p159,Nivel 30,p160");
        pokemons.add(totodile);
        Pokemon croconaw = new Pokemon(159, "Croconaw",
                "Una vez que Croconaw le ha clavado los colmillos a su presa, es imposible que escape porque los tiene hacia adentro como si fueran anzuelos. Cuando Croconaw hinca los dientes, no hay escapatoria.", agua, "p158,Nivel 18,p159,Nivel 30,p160");
        pokemons.add(croconaw);
        Pokemon feraligatr = new Pokemon(160, "Feraligatr",
                "Feraligatr intimida a sus oponentes abriendo las grandes fauces que tiene. En combate, golpea el suelo bruscamente con las gruesas y fuertes patas traseras que tiene para cargar contra su rival a una velocidad de vértigo.", agua, "p158,Nivel 18,p159,Nivel 30,p160");
        pokemons.add(feraligatr);
        Pokemon sentret = new Pokemon(161, "Sentret",
                "Sentret no duerme a menos que otro haga guardia. El que hace de centinela lo despertará al mínimo signo de peligro. Cuando este Pokémon se separa de su manada, es incapaz de echarse a dormir, presa del miedo.", normal, "p161,Nivel 15,p162");
        pokemons.add(sentret);
        Pokemon furret = new Pokemon(162, "Furret",
                "Furret es de constitución muy delgada. En combate le resulta útil porque puede escabullirse con habilidad por cualquier huequito y escapar. A pesar de que tiene patas cortas, es ágil y veloz.", normal, "p161,Nivel 15,p162");
        pokemons.add(furret);
        Pokemon hoothoot = new Pokemon(163, "Hoothoot",
                "Hoothoot tiene un órgano interno que identifica y percibe la rotación de la tierra. Gracias a este órgano, el Pokémon ulula todos los días a la misma hora.", new TipoDual(normal,volador), "p163,Nivel 20,p164");
        pokemons.add(hoothoot);
        Pokemon noctowl = new Pokemon(164, "Noctowl",
                "Noctowl no falla a la hora de cazar a su presa en la oscuridad. El éxito se lo debe a una vista privilegiada, que le permite ver donde apenas hay luz, y a las ligeras y flexibles alas que tiene, que no hacen ruido alguno al volar.", new TipoDual(normal, volador), "p163,Nivel 20,p164");
        pokemons.add(noctowl);
        Pokemon ledyba = new Pokemon(165, "Ledyba",
                "Ledyba segrega un fluido aromático por los seis puntos de unión que tiene entre las patas y el cuerpo. A través de este fluido se comunica con otros y les informa acerca de sus sentimientos variando la esencia.", new TipoDual(bicho,volador), "p165,Nivel 18,p166");
        pokemons.add(ledyba);
        Pokemon ledian = new Pokemon(166, "Ledian",
                "Dicen que en zonas en las que el aire está limpio, en las que se ven las estrellas, hay enormes poblaciones de Ledian. La razón es muy sencilla: este Pokémon usa la luz de las estrellas como fuente de energía.", new TipoDual(bicho,volador), "p165,Nivel 18,p166");
        pokemons.add(ledian);
        Pokemon spinarak = new Pokemon(167, "Spinarak",
                "La tela que teje Spinarak puede considerarse como su segundo sistema nervioso. Dicen que puede adivinar qué tipo de presa ha caído en su red con solo observar las leves vibraciones de los hilos de la tela.", new TipoDual(bicho, veneno), "p167,Nivel 22,p168");
        pokemons.add(spinarak);
        Pokemon ariados = new Pokemon(168, "Ariados",
                "Ariados tiene unas patas con forma de garfio que le permiten correr por techos y superficies verticales. Este Pokémon oprime al rival con una tela de araña fina y resistente.", new TipoDual(bicho, veneno), "p167,Nivel 22,p168");
        pokemons.add(ariados);
        Pokemon crobat = new Pokemon(169, "Crobat",
                "Cuando este Pokémon vuela batiendo solo las alas delanteras o traseras, es porque lleva volando bastante tiempo. Cuando se cansa, Crobat alterna las alas.", new TipoDual(veneno, volador), "p41,Nivel 22,p42,Amistad + Subier un nivel,p169");
        pokemons.add(crobat);
        Pokemon chinchou = new Pokemon(170, "Chinchou",
                "Chinchou libera cargas eléctricas positivas y negativas a través de las dos antenas que tiene para que su rival pierda el conocimiento. Asimismo, usa los destellos de electricidad para comunicarse con otros.", new TipoDual(agua,electrico), "p170,Nivel 27,p171");
        pokemons.add(chinchou);
        Pokemon lanturn = new Pokemon(171, "Lanturn",
                "A Lanturn lo llaman la Estrella del Fondo del Mar por la antena iluminada que tiene. Este Pokémon produce luz creando una reacción química entre una bacteria y los fluidos corporales de la antena.", new TipoDual(agua,veneno), "p170,Nivel 27,p171");
        pokemons.add(lanturn);
        Pokemon pichu = new Pokemon(172, "Pichu",
                "A Pichu le resulta más fácil cargarse de electricidad en días de nubarrones o cuando sopla un aire muy seco. Es posible oír la electricidad estática que emana de este Pokémon.", electrico, "p172,Amistad + subir un nivel,p25,Piedra Trueno,p26");
        pokemons.add(pichu);
        Pokemon cleffa = new Pokemon(173, "Cleffa",
                "Cuando hay lluvia de estrellas, a los Cleffa se les puede ver danzando en círculos durante toda la noche. Solo paran cuando rompe el día; entonces, dejan de bailar y calman su sed con el rocío de la mañana.", hada, "p173,Amistad + Subir un nivel,p35,Piedra Lunar,p36");
        pokemons.add(cleffa);
        Pokemon igglybuff = new Pokemon(174, "Igglypuff",
                "Las cuerdas vocales de Igglybuff no están suficientemente desarrolladas. Si tuviera que cantar mucho, se haría daño en la garganta. Este Pokémon suele hacer gárgaras con agua pura de manantial.", new TipoDual(normal, hada), "p174,Amistad + Subir un nivel,p39,Piedra Lunar,p40");
        pokemons.add(igglybuff);
        Pokemon togepi = new Pokemon(175, "Togepi",
                "Togepi usa los sentimientos positivos de compasión y alegría que desprenden las personas y los Pokémon. Este Pokémon almacena sentimientos de felicidad en su interior y después los comparte con otros.", hada, "p175,Amistad + Subir un nivel,p176");
        pokemons.add(togepi);
        Pokemon togetic = new Pokemon(176, "Togetic",
                "Dicen que Togetic es un Pokémon que trae buena suerte y que, si detecta a alguien que es puro de corazón, sale para compartir su alegría con él.", new TipoDual(hada, volador), "p175,Amistad + Subir un nivel,p176");
        pokemons.add(togetic);
        Pokemon natu = new Pokemon(177, "Natu",
                "Natu no puede volar porque las alas no le han crecido lo suficiente. Si alguien cruza la mirada con él, se la devolverá fijamente, aunque, si hace el mínimo movimiento, huirá dando saltitos para ponerse a salvo.", new TipoDual(psiquico, volador), "p177,Nivel 25,p178");
        pokemons.add(natu);
        Pokemon xatu = new Pokemon(178, "Xatu",
                "Xatu permanece de pie inmóvil y tranquilo en el mismo sitio durante todo el día. Se cree que no se mueve por temor a lo que ha visto que ocurrirá en el futuro.", new TipoDual(psiquico, volador), "p177,Nivel 25,p178");
        pokemons.add(xatu);
        Pokemon mareep = new Pokemon(179,"Mareep",
                "Mareep tiene un pelaje lanudo suave que produce carga estática por el roce. Cuanto más se carga de electricidad estática, más brilla la bombilla que tiene en el extremo de la cola.", electrico, "p179,Nivel 15,p180,Nivel 30,p181");
        pokemons.add(mareep);
        Pokemon flaaffy = new Pokemon(180, "Flaaffy",
                "La calidad de la lana de Flaaffy varía para poder generar mucha electricidad estática con muy poca cantidad de lana. Las zonas suaves de la piel en las que no tiene pelaje están protegidas contra la electricidad.", electrico, "p179,Nivel 15,p180,Nivel 30,p181");
        pokemons.add(flaaffy);
        Pokemon ampharos = new Pokemon(181, "Ampharos",
                "Ampharos desprende tanta luz que es posible verle hasta desde el espacio. Antes, la gente usaba su luz como sistema de comunicación para enviarse señales.", electrico, "p179,Nivel 15,p180,Nivel 30,p181");
        pokemons.add(ampharos);
        Pokemon bellossom = new Pokemon(182, "Bellossom",
                "Cuando Bellossom se expone a gran cantidad de luz solar, le empiezan a girar las hojas que le rodean. La danza de este Pokémon es famosa en las zonas del sur.", planta, "p43,Nivel 21,p44,Piedra hoja,p45,odd,Piedra solar,p182");
        pokemons.add(bellossom);
        Pokemon marill = new Pokemon(183, "Marill",
                "La cola de Marill contiene un aceite que hace las veces de chaleco salvavidas. Si ves una moviéndose en el agua, seguro que debajo hay un Marill medio sumergido buscando plantas acuáticas para comer.", new TipoDual(agua,hada), "p69,Nivel 21,p70,Piedra hoja,p71");
        pokemons.add(marill);
        Pokemon azumarill = new Pokemon(184, "Azumarill",
                "Azumarill puede hacer burbujas de aire si ve a algún Pokémon que esté a punto de ahogarse. Estas burbujas de aire son básicas para que los Pokémon puedan seguir respirando.", new TipoDual(agua, hada), "p69,Nivel 21,p70,Piedra hoja,p71");
        pokemons.add(azumarill);
        Pokemon sudowoodo = new Pokemon(185, "Sudowoodo",
                "Sudowoodo se camufla adoptando la imagen de un árbol para que no le ataque ningún enemigo. El problema viene en invierno, ya que las extremidades superiores tienen color verde y es fácil identificarle.",  roca, "p69,Nivel 21,p70,Piedra hoja,p71");
        pokemons.add(sudowoodo);
        Pokemon politoed = new Pokemon(186, "Politoed",
                "El mechón rizado de Politoed confirma su condición de rey. Dicen que cuanto más le crece y más se le riza, mayor es el respeto que recibe de sus súbditos.", agua);
        pokemons.add(politoed);
        Pokemon hoppip = new Pokemon(187, "Hoppip",
                "Este Pokémon flota en el aire y se deja llevar. Cuando percibe que el viento va a cambiar a fuerte, Hoppip entrelaza sus hojas con otros Hoppip para hacer resistencia y evitar salir volando por la fuerza de la corriente.", new TipoDual(planta, volador), "p69,Nivel 21,p70,Piedra hoja,p71");
        pokemons.add(hoppip);
        Pokemon skiplooom = new Pokemon (188, "Skiploom",
                "Skiploom florece cuando la temperatura llega a 18 °C. La apertura de los pétalos varía según la temperatura que haga. Por este motivo, la gente lo usa a veces a modo de termómetro.", new TipoDual(planta,volador), "p69,Nivel 21,p70,Piedra hoja,p71");
        pokemons.add(skiplooom);
        Pokemon jumpluff = new Pokemon(189, "Jumpluff",
                "Jumpluff se vale de los cálidos vientos del sur para volar a tierras lejanas. Si llega a zonas de aire frío en pleno vuelo, descenderá y tomará tierra.", new TipoDual(planta, volador), "p69,Nivel 21,p70,Piedra hoja,p71");
        pokemons.add(jumpluff);
        Pokemon aipom = new Pokemon(190, "Aipom",
                "La cola de Aipom termina en una especie de mano a la que, con un poco de cabeza, se le puede dar muy buen uso. Pero hay un problema: como se ha acostumbrado a usarla mucho, las de verdad se le han vuelto algo torponas.", normal, "p69,Nivel 21,p70,Piedra hoja,p71");
        pokemons.add(aipom);
        Pokemon sunkern = new Pokemon(191, "Sunkern",
                "Sunkern intenta moverse lo menos posible para conservar todos los nutrientes que ha guardado en su interior y poder evolucionar. Ni come siquiera; se alimenta solo del rocío de la mañana.", planta, "p69,Nivel 21,p70,Piedra hoja,p71");
        pokemons.add(sunkern);
        Pokemon sunflora = new Pokemon(192, "Sunflora",
                "Sunflora transforma la energía solar en nutrientes. De día, cuando hace calor, está en continuo movimiento. Solo para cuando comienza a anochecer.", planta);
        pokemons.add(sunflora);
        Pokemon yanma = new Pokemon(193, "Yanma",
                "Yanma tiene un ángulo de visión de 360° sin mover los ojos. Es un gran volador, experto en hacer repentinas paradas y cambios de dirección en el aire. Aprovecha la habilidad que tiene de volar para lanzarse sobre su presa.", new TipoDual(bicho, volador), "p69,Nivel 21,p70,Piedra hoja,p71");
        pokemons.add(yanma);
        Pokemon wooper = new Pokemon(194, "Wooper",
                "Wooper suele vivir en el agua, pero es posible también verle en tierra en busca de comida. Cuando está en terreno firme, se cubre con una película viscosa tóxica.", new TipoDual(agua, tierra), "p69,Nivel 21,p70,Piedra hoja,p71");
        pokemons.add(wooper);
        Pokemon quagsire = new Pokemon(195, "Quagsire",
                "Quagsire caza dejando las fauces abiertas en el agua y esperando a que su presa entre sin darse cuenta. Como se queda quieto, el Pokémon no pasa mucha hambre.", new TipoDual(agua, tierra), "p69,Nivel 21,p70,Piedra hoja,p71");
        pokemons.add(quagsire);
        Pokemon espeon = new Pokemon(196, "Espeon",
                "Espeon es tremendamente leal al Entrenador al que considera digno de ello. Dicen que este Pokémon desarrolló sus poderes adivinatorios para evitar que su Entrenador sufra daño alguno.", psiquico, "p69,Nivel 21,p70,Piedra hoja,p71");
        pokemons.add(espeon);
        Pokemon umbreon = new Pokemon(197, "Umbreon",
                "Umbreon evolucionó tras haber estado expuesto a ondas lunares. Suele esconderse en la oscuridad en silencio y esperar a que su presa se mueva. Cuando se lanza al ataque, le brillan los anillos del cuerpo.", siniestro, "p69,Nivel 21,p70,Piedra hoja,p71");
        pokemons.add(umbreon);
        Pokemon murkrow = new Pokemon(198, "Murkrow",
                "Murkrow ha sido temido y repudiado por todos por ser supuestamente fuente de mala suerte. Este Pokémon siente debilidad por todo lo que brilla y resplandece. A las mujeres les roba los anillos.", new TipoDual(siniestro, volador), "p69,Nivel 21,p70,Piedra hoja,p71");
        pokemons.add(murkrow);
        Pokemon slowking = new Pokemon(199, "Slowking",
                "Slowking dedica cada día tiempo a investigar, en un intento por resolver los misterios del mundo. Aunque, según parece, a este Pokémon se le olvida todo lo que ha aprendido si se separa del Shellder que lleva en la cabeza.", new TipoDual(agua, psiquico), "p69,Nivel 21,p70,Piedra hoja,p71");
        pokemons.add(slowking);
        Pokemon misdreavus = new Pokemon(200, "Misdreavus",
                "Misdreavus asusta a la gente con un chillido escalofriante y sollozante. Y, al parecer, usa las esferas rojas para absorber los sentimientos de miedo de los enemigos y usarlos como alimento.", fantastma, "p69,Nivel 21,p70,Piedra hoja,p71");
        pokemons.add(misdreavus);
        Pokemon unown = new Pokemon(201, "Unown",
                "Estos Pokémon tienen forma de caracteres antiguos. No se sabe qué surgió primero, si la vieja escritura o los distintos Unown. Esta cuestión sigue siendo objeto de estudio, pero aún no se ha averiguado nada.", psiquico, "p69,Nivel 21,p70,Piedra hoja,p71");
        pokemons.add(unown);
        Pokemon wobbuffet = new Pokemon(202, "Wobbuffet",
                "Si dos o más Wobbuffet se encuentran, se volverán competitivos e intentarán superarse en resistencia. Pero también puede que intenten aguantar sin comer; algo que los Entrenadores deben tener muy en cuenta.", psiquico, "p69,Nivel 21,p70,Piedra hoja,p71");
        pokemons.add(wobbuffet);
        Pokemon girafarig = new Pokemon(203, "Girafarig",
                "Girafarig tiene un cerebro también en la cabeza de la cola que reacciona atacando ante olores y sonidos. Cuando alguien se acerca a este Pokémon por la espalda, puede provocar que la cabeza trasera se abalance y lo muerda.", new TipoDual(normal,psiquico), "p69,Nivel 21,p70,Piedra hoja,p71");
        pokemons.add(girafarig);
        Pokemon pineco = new Pokemon(204, "Pineco",
                "Pineco permanece colgado de la rama de un árbol esperando pacientemente a su presa. Si alguien sacude el árbol en el que está mientras come y le molesta, se tira al suelo y explota sin dar ningún tipo de aviso.", bicho, "p69,Nivel 21,p70,Piedra hoja,p71");
        pokemons.add(pineco);
        Pokemon forretrest = new Pokemon(205, "Forretrest",
                "Forretress se esconde dentro de su concha de acero reforzada. Solo la abre cuando va a atrapar a su presa, pero ocurre tan rápido que no da tiempo de ver su interior.", new TipoDual(bicho, acero), "p69,Nivel 21,p70,Piedra hoja,p71");
        pokemons.add(forretrest);
        Pokemon dunsparce =  new Pokemon(206, "Dusnparce",
                "La cola de Dunsparce es un taladro que usa para enterrarse en el suelo de espaldas. De todos es sabido que este Pokémon hace su nido a gran profundidad y con una forma muy compleja.", normal, "p69,Nivel 21,p70,Piedra hoja,p71");
        pokemons.add(dunsparce);
        Pokemon gligar = new Pokemon(207, "Gligar",
                "Gligar planea por el aire sin hacer ningún ruido, como si fuera patinando. Este Pokémon se agarra a la cara de su rival con las patas traseras, con forma de garra, y las pinzas de las delanteras y le inyecta veneno por el aguijón.", new TipoDual(tierra, volador), "p69,Nivel 21,p70,Piedra hoja,p71");
        pokemons.add(gligar);
        Pokemon steelix = new Pokemon(208, "Steelix",
                "Steelix vive a mayor profundidad aún que Onix. Se le conoce por su tendencia a excavar hacia el interior del planeta. Hay datos que muestran que este Pokémon ha llegado a alcanzar 1 km de profundidad.", new TipoDual(acero, tierra), "p69,Nivel 21,p70,Piedra hoja,p71");
        pokemons.add(steelix);
        Pokemon snubbull = new Pokemon(209, "Snubbull",
                "Al tener los colmillos por fuera, Snubbull da miedo y espanta a los Pokémon pequeños, que huyen aterrados. Parece que a él le da un poco de pena que salgan huyendo.", hada, "p69,Nivel 21,p70,Piedra hoja,p71");
        pokemons.add(snubbull);
        Pokemon grandbull = new Pokemon(210, "Grandbull",
                "Granbull tiene la mandíbula inferior demasiado desarrollada y colmillos enormes y pesados que le obligan a inclinar la cabeza hacia atrás para compensar el peso. Si no se le asusta, no muerde.", hada, "p69,Nivel 21,p70,Piedra hoja,p71");
        pokemons.add(grandbull);
        Pokemon qwilfish  = new Pokemon(211, "Qwilfish",
                "Qwilfish bebe agua y se hincha, y a continuación usa la presión del agua que ha tragado para lanzar púas tóxicas por todo el cuerpo. Para este Pokémon nadar es una especie de desafío.", new TipoDual(agua,veneno), "p69,Nivel 21,p70,Piedra hoja,p71");
        pokemons.add(qwilfish);
        Pokemon scizor = new Pokemon(212, "Scizor",
                "Scizor tiene un cuerpo duro como el acero que no es fácil de alterar con ningún ataque común. Este Pokémon bate las alas para regular la temperatura corporal.", new TipoDual(bicho, acero), "p69,Nivel 21,p70,Piedra hoja,p71");
        pokemons.add(scizor);
        Pokemon shuckle = new Pokemon(213, "Shuckle",
                "Shuckle permanece escondido bajo las rocas en silencio y, cuando se pone a comer las bayas que almacena, se encierra en el caparazón. Las bayas se mezclan con sus fluidos corporales y originan zumo.", new TipoDual(bicho, roca), "p69,Nivel 21,p70,Piedra hoja,p71");
        pokemons.add(shuckle);
        Pokemon heracross = new Pokemon(214, "Heracross",
                "Heracross carga en línea recta contra el enemigo, se le queda encajado por debajo, lo agarra y lo lanza con ayuda del fuerte cuerno que tiene. Este Pokémon tiene fuerza hasta para echar abajo un árbol descomunal.", new TipoDual(bicho, lucha), "p69,Nivel 21,p70,Piedra hoja,p71");
        pokemons.add(heracross);
        Pokemon sneasel = new Pokemon(215, "Sneasel",
                "Sneasel trepa por los árboles agarrándose a la corteza con las garras curvas que tiene. Este Pokémon busca nidos desprovistos de vigilancia paterna para robar los huevos y comérselos.", new TipoDual(siniestro,hielo), "p69,Nivel 21,p70,Piedra hoja,p71");
        pokemons.add(sneasel);
        Pokemon teddiursa = new Pokemon(216, "Teddiursa",
                "A Teddiursa le encanta chuparse las palmas impregnadas de dulce miel. Este Pokémon fabrica su propia miel mezclando frutos y el polen que recoge Beedrill.", normal, "p69,Nivel 21,p70,Piedra hoja,p71");
        pokemons.add(teddiursa);
        Pokemon ursaring = new Pokemon(217, "Ursaring",
                "En los bosques habitados por Ursaring, dicen que abundan los arroyos y árboles gigantes en los que guardan su alimento. Este Pokémon se dedica todos los días a pasear por el bosque para buscar comida y guardarla.", normal, "p69,Nivel 21,p70,Piedra hoja,p71");
        pokemons.add(ursaring);
        Pokemon slugma = new Pokemon(218, "Slugma",
                "Por el sistema circulatorio de Slugma corre magma líquido. Si este Pokémon se enfriara, el magma perdería el calor y se solidificaría, por lo que se resquebrajaría por completo, perdería algunos trozos y reduciría su tamaño.", fuego, "p69,Nivel 21,p70,Piedra hoja,p71");
        pokemons.add(slugma);
        Pokemon magcargo = new Pokemon(219, "Magcargo",
                "La coraza de Magcargo es en realidad su propia piel que quedó endurecida al enfriarse. Está muy resquebrajada y es muy frágil; se desharía solo con tocarla. Este Pokémon debe sumergirse en magma para recuperar su forma.", new TipoDual(fuego, roca), "p69,Nivel 21,p70,Piedra hoja,p71");
        pokemons.add(magcargo);
        Pokemon swinub = new Pokemon(220, "Swinub",
                "Swinub busca el alimento frotando el hocico contra el suelo. Su comida preferida es una seta que crece bajo la hierba marchita. A veces, al frotar, descubre fuentes termales.", new TipoDual(hielo, tierra), "p69,Nivel 21,p70,Piedra hoja,p71");
        pokemons.add(swinub);
        Pokemon piloswine = new Pokemon(221, "Piloswine",
                "Piloswine está cubierto por un pelaje tupido y de largas cerdas que le permite soportar el frío polar. Este Pokémon usa los colmillos para desenterrar los alimentos que hayan podido quedar bajo el hielo.", new TipoDual(hielo, tierra), "p69,Nivel 21,p70,Piedra hoja,p71");
        pokemons.add(piloswine);
        Pokemon corsola = new Pokemon(222, "Corsola",
                "Las ramas de Corsola brillan con belleza hasta en siete colores cuando les da el sol. Si se le rompe alguna, el Pokémon la regenera en tan solo una noche.", new TipoDual(agua, roca), "p69,Nivel 21,p70,Piedra hoja,p71");
        pokemons.add(corsola);
        Pokemon remoraid = new Pokemon(223, "Remoraid",
                "Remoraid traga agua y usa los abdominales para lanzarla a gran velocidad contra una presa que esté en el aire. Cuando está a punto de evolucionar, este Pokémon nada en los ríos corriente abajo.", agua, "p69,Nivel 21,p70,Piedra hoja,p71");
        pokemons.add(remoraid);
        Pokemon octillery = new Pokemon(224, "Octillery",
                "Octillery se apodera de su enemigo con los tentáculos y lo deja inmovilizado antes de propinarle el golpe final. Si el enemigo resulta ser demasiado fuerte, Octillery expulsará tinta para escapar.", agua, "p69,Nivel 21,p70,Piedra hoja,p71");
        pokemons.add(octillery);
        Pokemon delibird = new Pokemon(225, "Delibird",
                "Delibird usa la cola a modo de saco para llevar su alimento. En una ocasión, un famoso escalador consiguió alcanzar la cima más alta del mundo gracias a que uno de estos Pokémon compartió sus alimentos con él.", new TipoDual(hielo, volador), "p69,Nivel 21,p70,Piedra hoja,p71");
        pokemons.add(delibird);
        Pokemon mantine = new Pokemon(226, "Mantine",
                "En los días que hace sol, es posible ver bancos de Mantine saltando con elegancia por entre las olas del mar. A estos Pokémon no les molestan los Remoraid que se les pegan.", new TipoDual(agua, volador), "p69,Nivel 21,p70,Piedra hoja,p71");
        pokemons.add(mantine);
        Pokemon skarmory = new Pokemon(227, "Skaromry",
                "Skarmory está totalmente encerrado en el interior de una fuerte coraza protectora. En vuelo, puede llegar a alcanzar los 300 km/h y usa las afiladas alas que tiene para azotar al rival.", new TipoDual(acero, volador), "p69,Nivel 21,p70,Piedra hoja,p71");
        pokemons.add(skarmory);
        Pokemon hondour = new Pokemon(228, "Hondour",
                "Houndour sale a cazar con el resto de la manada con total coordinación. Estos Pokémon se comunican unos con otros usando una serie de aullidos para acorralar a su presa. El compañerismo que existe entre ellos es incomparable.", new TipoDual(siniestro, fuego), "p69,Nivel 21,p70,Piedra hoja,p71");
        pokemons.add(hondour);
        Pokemon houndoom = new Pokemon(229, "Houndoom",
                "En la manada de Houndoom, el que tiene los cuernos más arqueados hacia atrás tiene un mayor papel de liderazgo. Estos Pokémon suelen elegir al jefe en duelo.", new TipoDual(siniestro, fuego), "p69,Nivel 21,p70,Piedra hoja,p71");
        pokemons.add(houndoom);
        Pokemon kingdra = new Pokemon(230, "Kingdra",
                "Kingdra vive en lo más profundo del océano, donde no habita ninguna otra especie. Siempre se ha pensado que su bostezo causaba las corrientes en remolino que se dan en el océano.", new TipoDual(agua, dragon), "p69,Nivel 21,p70,Piedra hoja,p71");
        pokemons.add(kingdra);
        Pokemon phanpy = new Pokemon(231, "Phanpy",
                "Phanpy cava un agujero profundo para hacer su nido en el suelo, en la ribera de los ríos, y marca con la trompa la zona para que el resto vea que ese terreno ya está ocupado.", tierra, "p69,Nivel 21,p70,Piedra hoja,p71");
        pokemons.add(phanpy);
        Pokemon donphan = new Pokemon(232, "Donphan",
                "A Donphan le encanta enrollarse como una pelota y cargar contra el enemigo rodando a toda velocidad. Una vez que ha comenzado a rodar, no es fácil pararlo.", tierra, "p69,Nivel 21,p70,Piedra hoja,p71");
        pokemons.add(donphan);
        Pokemon porygon2 = new Pokemon(233, "Porygon2",
                "Porygon2 fue creado por el hombre gracias a los avances de la ciencia. Esta obra humana ha sido provista de inteligencia artificial que le permite aprender gestos y sensaciones nuevas por su cuenta.", normal, "p69,Nivel 21,p70,Piedra hoja,p71");
        pokemons.add(porygon2);
        Pokemon stantler = new Pokemon(234, "Stantler",
                "Hace tiempo, se comerciaba con la magnífica cornamenta de Stantler. Se vendía como obra de arte a alto precio. Los interesados en cornamentas de valor incalculable empezaron a cazarlos y casi provocan su extinción.", normal, "p69,Nivel 21,p70,Piedra hoja,p71");
        pokemons.add(stantler);
        Pokemon smeargle = new Pokemon(235, "Smeargle",
                "Smeargle marca los límites de su territorio liberando un fluido corporal por el extremo de la cola. En la actualidad se han encontrado más de 5000 tipos de marcas distintas dejadas por este Pokémon.", normal, "p69,Nivel 21,p70,Piedra hoja,p71");
        pokemons.add(smeargle);
        Pokemon tyrogue = new Pokemon(236, "Tyrogue",
                "Tyrogue se pone demasiado nervioso si no lo sacan a entrenarse cada día. Su Entrenador debe establecer y mantener ciertos métodos de entrenamiento durante la cría.", lucha, "p69,Nivel 21,p70,Piedra hoja,p71");
        pokemons.add(tyrogue);
        Pokemon hitmontop = new Pokemon(237, "Hitmontop",
                "Hitmontop hace el pino con la cabeza y se pone a girar rápido al tiempo que reparte patadas. Esta es una técnica ofensiva y defensiva a la vez. Este Pokémon se desplaza más rápido girando sobre sí que caminando.", lucha, "p69,Nivel 21,p70,Piedra hoja,p71");
        pokemons.add(hitmontop);
        Pokemon smoochum = new Pokemon(238, "Smoochum",
                "Smoochum va corriendo por todos lados, pero se cae también con frecuencia. Y, en cuanto tiene ocasión, se mira en algún sitio para ver si se ha manchado la cara.", new TipoDual(hielo, psiquico), "p69,Nivel 21,p70,Piedra hoja,p71");
        pokemons.add(smoochum);
        Pokemon elekid = new Pokemon(239, "Elekid",
                "Elekid acumula electricidad. Si entra en contacto con algo de metal y descarga accidentalmente toda la electricidad almacenada, empieza a agitar los brazos en círculo para volver a cargarse.", electrico, "p69,Nivel 21,p70,Piedra hoja,p71");
        pokemons.add(elekid);
        Pokemon magby = new Pokemon(240, "Magby",
                "El estado de salud de Magby se puede determinar observando el fuego que emana al respirar. Si las llamas que echa por la boca son amarillas, está bien. Pero, si además de las llamas sale humo negro, está cansado.", fuego, "p69,Nivel 21,p70,Piedra hoja,p71");
        pokemons.add(magby);
        Pokemon miltank = new Pokemon(241, "Miltank",
                "Miltank da al día 20 l de una leche dulce que es la delicia de pequeños y mayores. Aquellos que no pueden tomarla, se decantan por los yogures.", normal, "p69,Nivel 21,p70,Piedra hoja,p71");
        pokemons.add(miltank);
        Pokemon blissey = new Pokemon(242, "Blissey",
                "Blissey es capaz de sentir la tristeza a través del sedoso pelaje. Si detecta que alguien está apenado, irá hasta donde esté y compartirá un Huevo Suerte para devolverle la sonrisa.", normal, "p69,Nivel 21,p70,Piedra hoja,p71");
        pokemons.add(blissey);
        Pokemon raikou = new Pokemon(243, "Raikou",
                "Raikou tiene la velocidad del rayo. Los rugidos de este Pokémon emiten ondas de choque que se esparcen vibrando por el aire y sacuden el suelo como si fueran auténticas descargas de rayo.", electrico, "p69,Nivel 21,p70,Piedra hoja,p71");
        pokemons.add(raikou);
        Pokemon entei = new Pokemon(244, "Entei",
                "Entei contiene el fulgor del magma en su interior. Se cree que este Pokémon nació de la erupción de un volcán. Escupe numerosas ráfagas de fuego que devoran y reducen a cenizas todo lo que tocan.", fuego, "p69,Nivel 21,p70,Piedra hoja,p71");
        pokemons.add(entei);
        Pokemon suicune = new Pokemon(245, "Suicune",
                "Suicune emana la pureza de los manantiales. Suele corretear por el campo con gran elegancia. Este Pokémon tiene el poder de purificar el agua contaminada.", agua);
        pokemons.add(suicune);
        Pokemon larvitar = new Pokemon(246, "Larvitar",
                "Larvitar nace bajo tierra a gran profundidad. Para subir a la superficie, este Pokémon debe comer lo que encuentra en su camino para abrirse paso. Y, hasta que no está arriba, no puede verles la cara a sus padres.", new TipoDual(roca, tierra), "p69,Nivel 21,p70,Piedra hoja,p71");
        pokemons.add(larvitar);
        Pokemon pupitar = new Pokemon(247, "Pupitar",
                "Pupitar crea un gas en su interior que comprime y expulsa violentamente a modo de autopropulsión. Tiene un cuerpo resistente que se mantiene inalterable hasta cuando se golpea contra duro acero.", new TipoDual(roca, tierra), "p69,Nivel 21,p70,Piedra hoja,p71");
        pokemons.add(pupitar);
        Pokemon tyranitar = new Pokemon(248, "Tyranitar",
                "Tyranitar tiene una fuerza imponente; es capaz de echar abajo una montaña para hacer su nido. Este Pokémon suele merodear por las zonas de montaña en busca de nuevos rivales contra los que luchar.", new TipoDual(roca, siniestro), "p69,Nivel 21,p70,Piedra hoja,p71");
        pokemons.add(tyranitar);
        Pokemon lugia = new Pokemon(249, "Lugia",
                "La fuerza que tiene Lugia en las alas es devastadora; con nada que las bata es capaz de derribar edificios enteros. Por eso mismo, prefiere vivir donde no haya nadie, en lo más profundo del mar.", new TipoDual(psiquico, volador), "p69,Nivel 21,p70,Piedra hoja,p71");
        pokemons.add(lugia);
        Pokemon hooh = new Pokemon(250, "Ho-Oh",
                "El plumaje de Ho-Oh contiene siete colores que pueden apreciarse según el ángulo desde el que les dé la luz. Dicen que sus plumas dan felicidad a quienes las llevan y, también, que este Pokémon vive a los pies del arco iris.", new TipoDual(fuego, volador), "p69,Nivel 21,p70,Piedra hoja,p71");
        pokemons.add(hooh);
        Pokemon celebi = new Pokemon(251, "Celebi",
                "Este Pokémon vino del futuro haciendo un viaje en el tiempo. Hay quien piensa que, mientras Celebi siga apareciendo, hay un futuro brillante y esperanzador.", new TipoDual(psiquico,planta), "p69,Nivel 21,p70,Piedra hoja,p71");
        pokemons.add(celebi);

        //Tercera Generacion

        /*Pokemon treecko = new Pokemon(252, "Treecko",
                "Treecko tiene unos ganchos pequeños en las plantas de los pies con los que puede escalar superficies verticales. Este Pokémon ataca dando un golpetazo con la cola.", planta);
        pokemons.add(treecko);
        Pokemon grovyle = new Pokemon(253, "Grovyle",
                "Las hojas que Grovyle tiene por el cuerpo le resultan muy útiles para camuflarse en el bosque y esconderse de los enemigos. A este Pokémon no hay quien lo supere subiendo a los árboles del bosque.", planta);
        pokemons.add(grovyle);
        Pokemon sceptile = new Pokemon(254, "Sceptile",
                "Las hojas que le salen a Sceptile del cuerpo tienen unos bordes muy afilados. Este Pokémon es muy ágil, va saltando de rama en rama y se lanza sobre el enemigo por la espalda.", planta);
        pokemons.add(sceptile);
        Pokemon torchic = new Pokemon(255, "Torchic",
                "Torchic no se separa de su Entrenador. Siempre va tras él con sus pasitos inseguros. Este Pokémon escupe bolas de fuego que pueden alcanzar los 1000 °C y carbonizar al enemigo.", fuego);
        pokemons.add(torchic);
        Pokemon combusken = new Pokemon(256, "Combusken",
                "Combusken fortalece las piernas corriendo por llanos y montañas. Este Pokémon tiene en las extremidades inferiores tanto fuerza como velocidad. Puede dar hasta diez patadas por segundo.", new TipoDual(fuego, lucha));
        pokemons.add(combusken);
        Pokemon blaziken = new Pokemon(257, "Blaziken",
                "En combate, Blaziken expulsa vivas llamas por las muñecas y ataca al enemigo con fiereza. Cuanto más fuerte sea el enemigo, más intensas serán las llamas.", new TipoDual(fuego, lucha));
        pokemons.add(blaziken);
        Pokemon mudkip = new Pokemon(258, "Mudkip",
                "La aleta que tiene Mudkip en la cabeza actúa de radar y es muy sensible. Puede captar movimientos que se produzcan en el agua y en el aire, y todo lo que ocurra a su alrededor, sin necesidad de abrir los ojos.", agua);
        pokemons.add(mudkip);
        Pokemon marshtomp = new Pokemon(259, "Marshtomp",
                "El cuerpo de Marshtomp está cubierto por una fina película pegajosa gracias a la cual puede vivir en tierra. Cuando la marea está baja, a este Pokémon le encanta jugar en el fango.", new TipoDual(agua, tierra));
        pokemons.add(marshtomp);
        Pokemon swampert = new Pokemon(260, "Swampert",
                "Swampert es muy fuerte. Puede arrastrar una roca que pese más de una tonelada sin ningún problema. Este Pokémon tiene el sentido de la vista muy desarrollado. Es capaz de ver hasta en aguas cenagosas.", new TipoDual(agua, tierra));
        pokemons.add(swampert);
        Pokemon poochyena = new Pokemon(261, "Poochyena",
                "La primera reacción que Poochyena tiene al ver algo moverse es darle un mordisco. Este Pokémon persigue a su presa hasta que cae agotada. Aunque, a veces, sale huyendo si su presa le responde con un ataque.", siniestro);
        pokemons.add(poochyena);
        Pokemon mightyena = new Pokemon(262, "Mightyena",
                "Es muy fácil prever cuándo va a atacar Mightyena; se pone a gruñir con fuerza y se estira. Este Pokémon da unos mordiscos tremendos con los afilados colmillos que tiene.", siniestro);
        pokemons.add(mightyena);
        Pokemon zigzagoon = new Pokemon(263, "Zigzagoon",
                "Zigzagoon está todo el día dando vueltas de aquí para allá. Es un Pokémon muy inquieto. Se interesa por todo lo que se encuentra en su camino.", normal);
        pokemons.add(zigzagoon);
        Pokemon linoone = new Pokemon(264, "Linoone",
                "Linoone siempre corre todo lo rápido que puede y solo en línea recta. Si encuentra un obstáculo en el camino, girará en ángulo recto para esquivarlo. Correr bien por caminos tortuosos es todo un reto para él.", normal);
        pokemons.add(linoone);
        Pokemon wurmple = new Pokemon(265, "Wurmple",
                "Wurmple usa las púas del lomo para raspar los troncos de los árboles, quitarles la corteza y beber la savia que emanan. Este Pokémon tiene unas ventosas rematándole los pies, con las que se adhiere al cristal sin resbalarse.", bicho);
        pokemons.add(wurmple);
        Pokemon silcoon = new Pokemon(266, "Silcoon",
                "Silcoon usa la seda que produce para aferrarse a la rama de un árbol y sujetarse bien. Se queda ahí colgado a la espera de su evolución, mientras lo observa todo a través de dos pequeños agujeros en su capullo de seda.", bicho);
        pokemons.add(silcoon);
        Pokemon beautifly = new Pokemon(267, "Beautifly",
                "La comida favorita de Beautifly es el dulce polen de las flores. Si quieres ver a este Pokémon, deja una maceta con flores al lado de la ventana y verás cómo aparece un ejemplar de Beautifly en busca de polen.", new TipoDual(bicho, volador));
        pokemons.add(beautifly);
        Pokemon cascoon = new Pokemon(268, "Cascoon",
                "Cascoon forma el capullo que lo protege enrollándose por completo en la seda que libera por la boca. Cuando está totalmente recubierto, se prepara para evolucionar en el interior del capullo.", bicho);
        pokemons.add(cascoon);
        Pokemon dustox = new Pokemon(269, "Dustox",
                "Los Dustox se acercan a la luz de forma instintiva. De hecho, se agrupan en enjambres alrededor de las luces de las ciudades y causan estragos en las hojas de los árboles que están a pie de calle para alimentarse.", new TipoDual(bicho,veneno));
        pokemons.add(dustox);
        Pokemon lotad = new Pokemon(270, "Lotad",
                "Lotad vive en estanques y lagos, donde permanece flotando. Si se le marchita la ancha hoja que tiene en la cabeza, se debilitará. De vez en cuando, se desplaza en busca de agua limpia.", new TipoDual(agua, planta));
        pokemons.add(lotad);
        Pokemon lombre = new Pokemon(271, "Lombre",
                "Lombre es, además de travieso, nocturno; entra en acción de noche. Cuando ve a gente pescando, se pone a tirar del sedal por debajo del agua y se divierte viendo la cara de enfado que se les queda.", new TipoDual(agua, planta));
        pokemons.add(lombre);
        Pokemon ludicolo = new Pokemon(272, "Ludicolo",
                "Ludicolo empieza a bailar en cuanto oye música alegre y de fiesta. Dicen que este Pokémon aparece cuando oye cantar a los niños que van de excursión para hacer senderismo.", new TipoDual(agua, planta));
        pokemons.add(ludicolo);
        Pokemon seedot = new Pokemon(273, "Seedot",
                "Seedot se queda enganchado a las ramas de los árboles por el extremo que tiene en la cabeza. Mientras está ahí colgado, aprovecha para tomar la humedad del árbol. Cuanta más agua bebe, más lustroso se le ve.", planta);
        pokemons.add(seedot);
        Pokemon nuzleaf = new Pokemon(274, "Nuzleaf",
                "Nuzleaf habita bosques muy poblados y, en ocasiones, se atreve a salir para asustar a la gente. A este Pokémon no le gusta nada que le pellizquen la nariz.", new TipoDual(planta,siniestro));
        pokemons.add(nuzleaf);
        Pokemon shiftry = new Pokemon(275, "Shiftry",
                "Shiftry es un enigmático Pokémon que vive, dicen, en las copas de los árboles milenarios. Este Pokémon genera fuertes corrientes de aire con los abanicos que lleva en las manos.", new TipoDual(planta,siniestro));
        pokemons.add(shiftry);
        Pokemon taillow = new Pokemon(276, "Taillow",
                "Taillow se mantiene firme ante sus rivales, sean lo fuertes que sean. Este valiente Pokémon seguirá mostrándose desafiante, aunque pierda en combate. Además, si se enfada, se pondrá a gritar con energía.", new TipoDual(normal,volador));
        pokemons.add(taillow);
        Pokemon swellow = new Pokemon(277, "Swellow",
                "Swellow vuela muy alto dibujando elegantes arcos en el cielo. Este Pokémon se sumerge en el agua con rapidez y eficacia en cuanto detecta una presa. Con las garras, atrapa a la desdichada víctima y no la deja huir.", new TipoDual(normal, volador));
        pokemons.add(swellow);
        Pokemon wingull = new Pokemon(278, "Wingull",
                "Wingull tiene la costumbre de llevar a su presa y objetos de valor en el pico, y esconderlos en distintos sitios. Este Pokémon vuela dejándose llevar por las corrientes de aire como si fuera patinando por el cielo.", new TipoDual(agua, volador));
        pokemons.add(wingull);
        Pokemon pelipper = new Pokemon(279, "Pelipper",
                "Pelipper vuela transportando pequeños huevos y Pokémon dentro del descomunal pico que tiene. Este Pokémon construye su nido en escarpados acantilados frente al mar.", new TipoDual(agua, volador));
        pokemons.add(pelipper);
        Pokemon ralts = new Pokemon(280, "Ralts",
                "Ralts percibe las sensaciones de la gente por los cuernos que tiene encima y detrás de la cabeza. No es común que este Pokémon aparezca en público, pero cuando lo hace, se acerca si ve buena disposición en la gente.", new TipoDual(psiquico, hada));
        pokemons.add(ralts);
        Pokemon kirlia = new Pokemon(281, "Kirlia",
                "Dicen que, al recibir los sentimientos positivos de su Entrenador, Kirlia crece con gran belleza. Este Pokémon controla poderes psicoquinéticos gracias al desarrollado cerebro que tiene.", new TipoDual(psiquico, hada));
        pokemons.add(kirlia);
        Pokemon gardevoir = new Pokemon(282, "Gardevoir",
                "Gardevoir es capaz de leer el futuro. Si siente que su Entrenador está en peligro inminente, dicen que libera automáticamente toda su energía psicoquinética.", new TipoDual(psiquico, hada));
        pokemons.add(gardevoir);
        Pokemon surskit = new Pokemon(283, "Surskit",
                "Surskit segrega un aceite por la punta de las patas que le permite caminar sobre el agua como si fuera patinando. Este Pokémon se alimenta de microorganismos en charcas y lagos.", new TipoDual(bicho, agua));
        pokemons.add(surskit);
        Pokemon masquerain = new Pokemon(284, "Masquerain",
                "Masquerain intimida a sus enemigos con los ojos que tiene dibujados en las antenas. Este Pokémon bate las cuatro alas que tiene para volar libremente en cualquier dirección, hasta de lado y hacia atrás, como un helicóptero.", new TipoDual(bicho, volador));
        pokemons.add(masquerain);
        Pokemon shroomish = new Pokemon(285, "Shroomish",
                "Los Shroomish viven en zonas húmedas en la profunda oscuridad del bosque. Suelen quedarse tranquilamente bajo las hojas caídas. Se alimentan del abono que estas generan al empezar a pudrirse.", planta);
        pokemons.add(shroomish);
        Pokemon breloom = new Pokemon(286, "Breloom",
                "Breloom se acerca al enemigo realizando un juego de piernas ágil y enérgico. Y, a continuación, le da unos puñetazos con los brazos elásticos que tiene. Las técnicas de lucha que usa dejan en ridículo al boxeador más profesional.", new TipoDual(planta, lucha));
        pokemons.add(breloom);
        Pokemon slakoth = new Pokemon(287, "Slakoth",
                "Slakoth se pasa más de veinte horas al día tumbado. Como se mueve tan poco, necesita muy poca comida. De hecho, la única toma que hace al día la componen tan solo tres hojas.", normal);
        pokemons.add(slakoth);
        Pokemon vigoroth = new Pokemon(288, "Vigoroth",
                "Vigoroth está continuamente inquieto, rabiando por salir corriendo sin control. Estar quieto un solo minuto es superior a sus fuerzas. Si no puede estar en continuo movimiento, el nivel de estrés de este Pokémon se dispara.", normal);
        pokemons.add(vigoroth);
        Pokemon slaking = new Pokemon(289, "Slaking",
                "Slaking se pasa todo el día tumbado vagueando. Se come la hierba que tiene a su alcance y, una vez que ha acabado con ella, se va de mala gana a otro sitio.", normal);
        pokemons.add(slaking);
        Pokemon nincada = new Pokemon(290, "Nincada",
                "Nincada vive bajo tierra en la más absoluta oscuridad durante años. Este Pokémon absorbe nutrientes de las raíces de los árboles y permanece inmóvil a la espera de su evolución.", new TipoDual(bicho, tierra));
        pokemons.add(nincada);
        Pokemon ninjask = new Pokemon(291, "Ninjask",
                "Ninjask se mueve de un lado a otro a tal velocidad que es imposible verlo. Sin embargo, como su zumbido no deja de oírse, se pensó durante mucho tiempo que este Pokémon era invisible.", new TipoDual(bicho,volador));
        pokemons.add(ninjask);
        Pokemon shedinja = new Pokemon(292, "Shedinja",
                "Shedinja tiene un cuerpo robusto que no mueve en absoluto. De hecho, parece una especie de caparazón hueco. Se cree que, si alguien se atreviera a mirarle por la espalda lo que tiene en su interior, Shedinja le robaría el alma.", new TipoDual(bicho, fantastma));
        pokemons.add(shedinja);
        Pokemon whismur = new Pokemon(293, "Whismur",
                "Normalmente, Whismur tiene una voz tenue, casi inaudible, aunque se preste atención. No obstante, si este Pokémon siente que el peligro acecha, puede ponerse a chillar con un volumen ensordecedor.", normal);
        pokemons.add(whismur);
        Pokemon loudred = new Pokemon(294, "Loudred",
                "Los bramidos de Loudred pueden echar abajo una casa reforzada con vigas de madera. Este Pokémon usa el vozarrón que tiene para castigar a sus rivales. Las orejas redondas le sirven de altavoces.", normal);
        pokemons.add(loudred);
        Pokemon exploud = new Pokemon(295, "Exploud",
                "Exploud provoca terremotos con el temblor que causa al levantar la voz. Cuando inhala aire por los tubos, hay que prestar atención, ya que está a punto de soltar un buen bramido.", normal);
        pokemons.add(exploud);
        Pokemon makuhita = new Pokemon(296, "Makuhita",
                "Makuhita es tenaz. Da igual las veces que le venzan; volverá a ponerse en pie y a atacar. De hecho, cada vez que se recupera, acumula más energía para poder evolucionar.", lucha);
        pokemons.add(makuhita);
        Pokemon hariyama = new Pokemon(297, "Hariyama",
                "Hariyama practica los empujones que da estirando los brazos allá por donde va. Este Pokémon puede partir por la mitad un poste de teléfono de un enérgico golpe con los brazos estirados y las manos abiertas.", lucha);
        pokemons.add(hariyama);
        Pokemon azurill = new Pokemon(298, "Azurill",
                "Azurill enrolla la cola como si fuera un lazo y la despliega a continuación todo lo que puede. De esta forma, un Azurill llegó a lanzarse a sí mismo hasta 10 m.", new TipoDual(normal, hada));
        pokemons.add(azurill);
        Pokemon nosepass = new Pokemon(299, "Nosepass",
                "Nosepass siempre está con la nariz magnética que tiene orientada hacia el norte. Si se encuentra con otro ejemplar de su especie, no puede mirarle de frente porque sus polos magnéticos se repelen.", roca);
        pokemons.add(nosepass);
        Pokemon skitty = new Pokemon(300, "Skitty",
                "A Skitty le encanta mover cosas e ir detrás de ellas. Es de todos sabido que se dedica a ir detrás de su propia cola y que, al final, acaba mareándose.", normal);
        pokemons.add(skitty);
        Pokemon delcatty = new Pokemon(301, "Delcatty",
                "Delcatty prefiere llevar una vida independiente y hacer lo que se le antoje. Como este Pokémon come y duerme según vea en cada momento, no se puede decir que tenga unos hábitos regulares en el día a día.", normal);
        pokemons.add(delcatty);
        Pokemon sableye = new Pokemon(302, "Sableye",
                "Los Sableye hacen una vida muy tranquila en cavernas, pero son muy temidos. Se dice que, cuando los ojos les brillan de manera siniestra, están robándole el alma a alguien.", new TipoDual(siniestro, fantastma));
        pokemons.add(sableye);
        Pokemon mawile = new Pokemon(303, "Mawile",
                "Las descomunales fauces de acero de Mawile son la evolución de unos cuernos que tuvo en su día. Con su expresión dócil puede engañar al enemigo y hacer que baje la guardia para sorprenderle con las fauces.", new TipoDual(acero, hada));
        pokemons.add(mawile);
        Pokemon aron = new Pokemon(304, "Aron",
                "Este Pokémon tiene el cuerpo de acero. Para mantenerlo, se alimenta del hierro que saca de las montañas. A veces, causa verdaderos problemas, pues se come puentes y vías de tren.", new TipoDual(acero, roca));
        pokemons.add(aron);
        Pokemon lairon = new Pokemon(305, "Lairon",
                "Lairon templa su cuerpo de acero bebiendo agua mineral muy rica en nutrientes hasta que no puede más. Este Pokémon suele crear su nido cerca de manantiales de rica agua.", new TipoDual(acero, roca));
        pokemons.add(lairon);
        Pokemon aggron = new Pokemon(306, "Aggron",
                "Aggron marca una montaña entera como su territorio y acaba con todo lo que pueda ponerlo en peligro. Este Pokémon está continuamente patrullando la zona en defensa de su terreno.", new TipoDual(acero, roca));
        pokemons.add(aggron);
        Pokemon meditite = new Pokemon(307, "Meditite",
                "Meditite lleva a cabo un entrenamiento mental exhaustivo en lo más profundo de las montañas. Aunque, cuando medita, pierde toda la concentración y se descentra. Por eso, no deja nunca de entrenarse.", new TipoDual(lucha, psiquico));
        pokemons.add(meditite);
        Pokemon medicham = new Pokemon(308, "Medicham",
                "Dicen que, a través de la meditación, Medicham aumenta su energía interior y agudiza su sexto sentido. Este Pokémon suele pasar desapercibido mimetizándose con el campo y las montañas.", new TipoDual(lucha ,psiquico));
        pokemons.add(medicham);
        Pokemon electrike = new Pokemon(309, "Electrike",
                "Electrike acumula electricidad en el largo pelaje que tiene. Este Pokémon estimula los músculos de las patas mediante descargas eléctricas. Estas explosiones de energía le permiten acelerar de forma increíble.", electrico);
        pokemons.add(electrike);
        Pokemon macnectric = new Pokemon(310, "Macnectric",
                "Manectric está continuamente descargando electricidad por las melenas, y a veces causa incendios en el bosque con las chispas que suelta. Cuando entra en combate, este Pokémon crea nubarrones.", electrico);
        pokemons.add(macnectric);
        Pokemon plusle = new Pokemon(311, "Plusle",
                "Plusle siempre anima a sus compañeros. Cuando algún miembro de su grupo hace un gran esfuerzo en combate, causa un cortocircuito en su interior para mostrar con el chisporroteo su alegría.", electrico);
        pokemons.add(plusle);
        Pokemon minum = new Pokemon(312, "Minum",
                "Minun se preocupa más por alentar a sus compañeros de equipo que por su propia seguridad. Para animar a los miembros de su grupo, crea un cortocircuito en su interior y libera un chisporroteo espectacular.", electrico);
        pokemons.add(minum);
        Pokemon volbeat = new Pokemon(313, "Volbeat",
                "Cuando llega la noche, Volbeat emite luz por la cola y regula la intensidad y el destello para comunicarse con el resto. A este Pokémon le atrae el dulce aroma de Illumise.", bicho);
        pokemons.add(volbeat);
        Pokemon illumise = new Pokemon(314, "Illumise",
                "Illumise atrae mediante su dulce aroma a enjambres de Volbeat. Una vez que los ha agrupado, les guía en el vuelo para que dibujen formas geométricas en el lienzo del oscuro cielo.", bicho);
        pokemons.add(illumise);
        Pokemon roselia = new Pokemon(315, "Roselia",
                "Roselia lanza finas espinas a todo el que se le acerca con intención de robarle las flores de los brazos. El aroma de este Pokémon resulta relajante a los seres vivos.", new TipoDual(planta, veneno));
        pokemons.add(roselia);
        Pokemon gulpin = new Pokemon(316, "Gulpin",
                "Casi la totalidad del cuerpo de Gulpin está compuesto por el estómago. Por eso, puede tragarse todo lo que tenga su tamaño. En el interior del estómago tiene un fluido capaz de corroerlo todo.", veneno);
        pokemons.add(gulpin);
        Pokemon swalot = new Pokemon(317, "Swalot",
                "Cuando Swalot detecta una presa, echa por los poros, y a borbotones, un fluido tóxico espantoso con el que rocía a su víctima. Una vez que la debilita, se la traga entera gracias a la gigantesca boca que tiene.", veneno);
        pokemons.add(swalot);
        Pokemon carvanha = new Pokemon(318, "Carvanha",
                "Carvanha, gracias a las descomunales fauces de afilados colmillos que tiene, es capaz de hacer trizas un barco. Son muchas las naves que han sufrido el ataque de este Pokémon y han acabado naufragando.", new TipoDual(agua, siniestro));
        pokemons.add(carvanha);
        Pokemon sharpedo = new Pokemon(319, "Sharpedo",
                "Conocido como el Terror de los Mares, Sharpedo es temido por todos. Si este Pokémon pierde los escalofriantes colmillos que tiene, los recupera en breve. Basta con un Sharpedo para destrozar un buque-cisterna.", new TipoDual(agua, siniestro));
        pokemons.add(sharpedo);
        Pokemon wailmer = new Pokemon(320, "Wailmer",
                "Wailmer tiene los espiráculos encima de la cabeza. A este juguetón Pokémon le encanta asustar a la gente expulsando el agua que acumula a través de estos orificios.", agua);
        pokemons.add(wailmer);
        Pokemon wailord = new Pokemon(321, "Wailord",
                "Wailord es el mayor Pokémon registrado hasta la fecha. Este coloso va nadando lánguidamente por el ancho mar con la boca abierta para que penetre la mayor cantidad posible de alimento.", agua);
        pokemons.add(wailord);
        Pokemon numel = new Pokemon(322, "Numel",
                "Numel tarda en percibir las cosas, no se entera ni cuando lo golpean, pero se da cuenta enseguida de si tiene hambre. El cuerpo de este Pokémon es un caldero de magma hirviendo.", new TipoDual(fuego, tierra));
        pokemons.add(numel);
        Pokemon camerupt = new Pokemon(323,"Camerupt",
                "Camerupt encierra un volcán en su interior y magma de 10 000 °C le recorre el cuerpo. A veces, las jorobas de la espalda entran en erupción y escupen el abrasivo magma.", new TipoDual(fuego, tierra));
        pokemons.add(camerupt);
        Pokemon torkoal = new Pokemon(324, "Torkoal",
                "Torkoal va cavando por las montañas en busca de carbón. Cuando lo encuentra, rellena los huecos que tiene dentro del caparazón y lo quema. Si le atacan, este Pokémon echa un humo negro que le permite la retirada.", fuego);
        pokemons.add(torkoal);
        Pokemon spoink = new Pokemon(325, "Spoink",
                "Spoink se pasa todo el día saltando sobre la cola. Cada salto hace que le lata el corazón. Por eso, no puede permitirse dejar de saltar. Si lo hiciera, se le pararía.", psiquico);
        pokemons.add(spoink);
        Pokemon grumpig = new Pokemon(326, "Grumpig",
                "Grumpig usa las perlas negras que tiene para amplificar las ondas de su poder psíquico y controlar del todo al rival. Cuando usa su poder especial, le cuesta respirar y resopla con pesadez.", psiquico);
        pokemons.add(grumpig);
        Pokemon spinda = new Pokemon(327, "Spinda",
                "Dicen que no hay dos Spinda que tengan los mismos dibujos en el pelaje. Este Pokémon tiene una forma de andar inestable, va tambaleándose. Da la sensación de ir bailando.", normal);
        pokemons.add(spinda);
        Pokemon trapinch = new Pokemon(328, "Trapinch",
                "El nido de Trapinch está situado bajo la arena, en una zona cóncava. Este Pokémon espera con paciencia a que su presa caiga en la misma. Con las fauces que tiene puede destruir hasta piedras.", tierra);
        pokemons.add(trapinch);
        Pokemon vibrava = new Pokemon(329, "Vibrava",
                "Para debilitar a su víctima, Vibrava genera ondas ultrasónicas haciendo vibrar con fuerza las alas. Las ondas que crea son tan fuertes que pueden dar dolor de cabeza a la gente.", new TipoDual(tierra, dragon));
        pokemons.add(vibrava);
        Pokemon flygon = new Pokemon(330, "Flygon",
                "A Flygon se le conoce como el Espíritu del Desierto. Al volar, como levanta una nube de arena al batir las alas, está siempre envuelto en una tormenta de arena.", new TipoDual(tierra, dragon));
        pokemons.add(flygon);
        Pokemon cacnea = new Pokemon(331, "Cacnea",
                "Cacnea habita en desiertos y otras zonas áridas. Para atraer a su presa, libera un fuerte aroma por la flor y, cuando se le acerca, le lanza pinchos por todo el cuerpo para reducirla.", planta);
        pokemons.add(cacnea);
        Pokemon cacturne = new Pokemon(332, "Cacturne",
                "Durante el día, Cacturne permanece inmóvil para no perder nada de humedad bajo el sol de justicia del desierto. Este Pokémon entra en acción por la noche, cuando bajan las temperaturas.", new TipoDual(planta, siniestro));
        pokemons.add(cacturne);
        Pokemon swablu = new Pokemon(333, "Swablu",
                "Swablu tiene unas alas ligeras y esponjosas que parecen nubes de algodón. A este Pokémon no le asusta la gente. De hecho, puede llegar a posarse en la cabeza de alguien y servirle de gorro sedoso.", new TipoDual(normal, dragon));
        pokemons.add(swablu);
        Pokemon altaria = new Pokemon(334, "Altaria",
                "Altaria baila y revolotea por el cielo entre ondeantes nubes que parecen de algodón. Al entonar melodías con su voz cristalina, este Pokémon deja a sus oyentes embobados y admirados.", new TipoDual(dragon, volador));
        pokemons.add(altaria);
        Pokemon zangoose = new Pokemon(335, "Zangoose",
                "Los ecos del combate mantenido con su rival más feroz, Seviper, resuenan aún en cada célula de Zangoose. Este Pokémon esquiva los ataques con auténtica destreza.", normal);
        pokemons.add(zangoose);
        Pokemon seviper = new Pokemon(336, "Seviper",
                "Seviper lleva años de gran enemistad con Zangoose. Las cicatrices que tiene por todo el cuerpo dan buena muestra de los encarnizados combates en los que se han enfrentado. Seviper ataca usando su cola con forma de espada.", veneno);
        pokemons.add(seviper);
        Pokemon lunatone = new Pokemon(337, "Lunanote",
                "Lunatone fue descubierto en el lugar de impacto de un meteorito. Por eso, hay quien especula con la idea de que procede del espacio. Con todo, hasta el día de hoy nadie ha podido probar esta teoría.", new TipoDual(roca, psiquico));
        pokemons.add(lunatone);
        Pokemon solrock = new Pokemon(338, "Solrock",
                "Solrock pertenece a una nueva especie de Pokémon a la que se le atribuye una procedencia extraterrestre. Este Pokémon permanece flotando en el aire y se mueve muy despacio. Al luchar, desprende una luz viva e intensa.", new TipoDual(roca, psiquico));
        pokemons.add(solrock);
        Pokemon barboach = new Pokemon(339, "Barboach",
                "Barboach tiene unos bigotes sensibles que le sirven de infalible radar. Este Pokémon se sumerge en lodo y solo deja los bigotes por fuera de la superficie, al acecho, mientras espera a que llegue su presa.", new TipoDual(agua, tierra));
        pokemons.add(barboach);
        Pokemon whiscash = new Pokemon(340, "Whiscash",
                "Whiscash defiende su territorio a toda costa. Es capaz de apoderarse de un estanque entero para sí solo. Si alguien se le acerca, se revolverá y provocará un terremoto devastador.", new TipoDual(agua, tierra));
        pokemons.add(whiscash);
        Pokemon corphish = new Pokemon(341, "Corphish",
                "En un principio, se importaban Corphish como mascota. Pero, al final, se hicieron salvajes. Este Pokémon es muy resistente y ha aumentado su población de forma considerable.", agua);
        pokemons.add(corphish);
        Pokemon crawdaunt = new Pokemon(342, "Crawdaunt",
                "Crawdaunt es de una naturaleza extremadamente violenta que le lleva a desafiar a otros seres vivos. Hay formas de vida que se niegan a vivir en los estanques donde habitan estos Pokémon, y los dejan medio vacíos.", new TipoDual(agua, siniestro));
        pokemons.add(crawdaunt);
        Pokemon baltoy = new Pokemon(343, "Baltoy",
                "Baltoy se mueve girando alrededor de sí mismo sobre la extremidad inferior que tiene. En unas ruinas antiguas, descubrieron pinturas rupestres en las que aparecía este Pokémon conviviendo con personas.", new TipoDual(tierra, psiquico));
        pokemons.add(baltoy);
        Pokemon claydol = new Pokemon(344, "Claydol",
                "Se cree que los Claydol son figuras de barro hechas por humanos primitivos y que un misterioso rayo les hizo cobrar vida. Este Pokémon se desplaza levitando.", new TipoDual(tierra, psiquico));
        pokemons.add(claydol);
        Pokemon lileep = new Pokemon(345, "Lileep",
                "Los Lileep se extinguieron hace unos cien millones de años aproximadamente. Este Pokémon se ancla a una roca en el fondo del mar y atrapa a las presas que se le acercan con los tentáculos que tiene en forma de pétalos de flor.",  new TipoDual(roca, planta));
        pokemons.add(lileep);
        Pokemon cradily = new Pokemon(346, "Cradily",
                "Cradily va por el fondo oceánico sin rumbo fijo en busca de comida. El cuello de este Pokémon se parece al tronco de un árbol. Cuando quiere atrapar a su presa desprevenida, lo estira y usa los ocho tentáculos que tiene.", new TipoDual(roca, planta));
        pokemons.add(cradily);
        Pokemon anorith = new Pokemon(347, "Anorith",
                "Anorith se regeneró a partir de un fósil prehistórico. Este Pokémon primitivo vivía en mares cálidos. Gracias a sus enormes pinzas puede agarrar a su presa con firmeza.", new TipoDual(roca, bicho));
        pokemons.add(anorith);
        Pokemon armaldo = new Pokemon(348, "Armaldo",
                "Armaldo tiene una sólida armadura que repele cualquier ataque. Este Pokémon puede estirar o encoger todo lo que quiera las pinzas que tiene. Con ellas, puede atravesar una plancha de acero.", new TipoDual(roca, bicho));
        pokemons.add(armaldo);
        Pokemon feebad = new Pokemon(349, "Feebas",
                "Feebas tiene las aletas melladas y rasgadas desde que nace. Debido a este aspecto poco imponente, son pocos los que lo tienen en cuenta. Este Pokémon puede vivir tanto en agua salada como dulce.", agua);
        pokemons.add(feebad);
        Pokemon milotic = new Pokemon(350, "Milotic",
                "De Milotic se dice que es el Pokémon más bello. Tiene la capacidad de calmar sentimientos tales como el miedo y la hostilidad, y apaciguar las relaciones de áspera enemistad.", agua);
        pokemons.add(milotic);
        Pokemon castform = new Pokemon(351, "Castform",
                "La forma de Castform cambia con las variaciones del tiempo. Este Pokémon consiguió aprender a usar el gran poder de la naturaleza para proteger el pequeño cuerpo que tiene.", normal);
        pokemons.add(castform);
        Pokemon kecleon = new Pokemon(352, "Kecleon",
                "Kecleon puede alterar la pigmentación de la piel para mezclarse con su entorno. Lo único que no es capaz de cambiar es el trazado en zigzag que tiene en la panza.", normal);
        pokemons.add(kecleon);
        Pokemon shuppet = new Pokemon(353, "Shuppet",
                "A Shuppet le atraen los sentimientos de celos y rencor. Si alguien desarrolla fuertes sentimientos de venganza, aparecerá una multitud de Shuppet que se quedará bajo los aleros de su casa.", fantastma);
        pokemons.add(shuppet);
        Pokemon banette = new Pokemon(354, "Banette",
                "Banette genera energía para echar un infalible hechizo clavándose púas a sí mismo. Los orígenes de este Pokémon son algo tristes: era un muñeco de felpa al que tiraron a la basura.", fantastma);
        pokemons.add(banette);
        Pokemon duskull = new Pokemon(355, "Duskull",
                "Duskull puede atravesar los muros, sea cual sea el grosor que tengan. Cuando este Pokémon elige su objetivo, lo persigue hábilmente hasta el amanecer.", fantastma);
        pokemons.add(duskull);
        Pokemon dusclops = new Pokemon(356, "Dusclops",
                "Dusclops está completamente hueco por dentro. Dicen que su cuerpo es como un agujero negro. Este Pokémon es capaz de absorber cualquier cosa, pero cosa que absorba, cosa que no dejará salir nunca más.", fantastma);
        pokemons.add(dusclops);
        Pokemon tropius = new Pokemon(357, "Tropius",
                "A los niños les encantan los racimos de fruta que Tropius tiene en el cuello. Este Pokémon siempre come fruta; le encanta. De hecho, ese parece ser el motivo por el que él mismo da fruta.", new TipoDual(planta, volador));
        pokemons.add(tropius);
        Pokemon chimeco = new Pokemon(358, "Chimeco",
                "Chimecho hace que sus gritos resuenen con eco en su interior. Cuando se enfada, los chillidos se convierten en ondas ultrasónicas capaces de derribar a los enemigos voladores.", psiquico);
        pokemons.add(chimeco);
        Pokemon absol = new Pokemon(359, "Absol",
                "Cada vez que Absol aparece ante la gente, ocurre una catástrofe natural como un terremoto o un maremoto. Por esta razón se le conoce como el Pokémon de las catástrofes.", siniestro);
        pokemons.add(absol);
        Pokemon wynaut = new Pokemon(360, "Wynaut",
                "Wynaut está siempre con una gran sonrisa puesta. Para ver si está enfadado, basta con mirarle la cola. Cuando se le molesta, se pone a dar golpetazos en el suelo.", psiquico);
        pokemons.add(wynaut);
        Pokemon snorut = new Pokemon(361, "Snorunt",
                "Snorunt vive en zonas de grandes nevadas. En primavera y verano, cuando no nieva, se retira a las cavernas para vivir tranquilamente entre estalactitas y estalagmitas.", hielo);
        pokemons.add(snorut);
        Pokemon glalie = new Pokemon(362, "Glalie",
                "Glalie endurece el cuerpo rocoso que tiene con una coraza de hielo. Este Pokémon tiene la habilidad de congelar la humedad del ambiente y formar la figura que se le antoje.", hielo);
        pokemons.add(glalie);
        Pokemon spheal = new Pokemon(363, "Spheal",
                "Spheal se desplaza por el suelo más rápido rodando que caminando. Cuando come con otros de su especie, todos se ponen a aplaudir para expresar su alegría. Por eso, a veces son algo escandalosos.", new TipoDual(hielo,agua));
        pokemons.add(spheal);
        Pokemon sealeo = new Pokemon(364, "Sealeo",
                "Cada vez que Sealeo ve algo nuevo, se lo pone en el morro y empieza a darle vueltas. A veces, para entretenerse, hace lo mismo con un Spheal.", new TipoDual(hielo, agua));
        pokemons.add(sealeo);
        Pokemon walrein = new Pokemon(365, "Walrein",
                "Walrein tiene unos exagerados colmillos con los que puede hacer añicos bloques de hielo de hasta 10 toneladas de una sola dentellada. La gruesa capa de grasa que lo recubre le protege de temperaturas inferiores a 0 °C.", new TipoDual(hielo, agua));
        pokemons.add(walrein);
        Pokemon clamperl = new Pokemon(366, "Clamperl",
                "La sólida concha que rodea a Clamperl no solo le sirve para protegerse, sino también de cepo para atrapar a su presa. Cuando la concha alcanza su mayor tamaño, presenta muescas y rasguños por todas partes.", agua);
        pokemons.add(clamperl);
        Pokemon huntail = new Pokemon(367, "Huntail",
                "Huntail ha pasado desapercibido durante mucho tiempo por vivir en las profundidades del mar. El sentido de la vista de este Pokémon le permite ver en las oscuras y turbias aguas submarinas.", agua);
        pokemons.add(huntail);
        Pokemon gorebyss = new Pokemon(368, "Gorebyss",
                "Gorebyss vive en los mares del sur, en lo más profundo; de ahí que tenga el cuerpo preparado para soportar la presión tan grande que hay en el fondo marino, y que no le hagan daño los ataques comunes.", agua);
        pokemons.add(gorebyss);
        Pokemon relicanth = new Pokemon(369, "Relicanth",
                "Relicanth pertenece a una especie de Pokémon que lleva millones de años sin cambiar de forma. Este ancestral Pokémon se alimenta de microorganismos por la boca desdentada que tiene.", new TipoDual(agua, roca));
        pokemons.add(relicanth);
        Pokemon luvdisc = new Pokemon(370, "Luvdisc",
                "Luvdisc vive en aguas tropicales poco profundas. Este Pokémon con forma de corazón se ha ganado la reputación que tiene por ir nadando detrás de las parejas de enamorados que veía entre las olas del océano.", agua);
        pokemons.add(luvdisc);
        Pokemon bagon = new Pokemon(371, "Bagon",
                "Bagon sueña con poder pasar un día volando por el cielo. En vanos intentos por volar, ha llegado a tirarse desde riscos. Como resultado de estas caídas en picado, se le ha puesto la cabeza dura como las piedras.", dragon);
        pokemons.add(bagon);
        Pokemon shelgon = new Pokemon(372, "Shelgon",
                "Dentro de la capa acorazada de Shelgon, las células están en pleno proceso de creación de un cuerpo nuevo. El peso de la coraza le hace tener unos movimientos lentos.", dragon);
        pokemons.add(shelgon);
        Pokemon salamance = new Pokemon(373, "Salamence",
                "Salamence surgió del profundo deseo de tener alas. Dicen que este fuerte deseo fue lo que causó la repentina mutación de las células y el crecimiento de las alas.", new TipoDual(dragon, volador));
        pokemons.add(salamance);
        Pokemon beldum = new Pokemon(374, "Beldum",
                "En lugar de sangre, Beldum tiene una poderosa fuerza magnética corriéndole por las venas. Este Pokémon se comunica enviando controlados impulsos magnéticos.", new TipoDual(acero, psiquico));
        pokemons.add(beldum);
        Pokemon metang = new Pokemon(375, "Metang",
                "Cuando dos Beldum se fusionan, forman un Metang. Los cerebros de los Beldum se unen mediante un sistema nervioso magnético y generan potente energía psicoquinética.", new TipoDual(acero, psiquico));
        pokemons.add(metang);
        Pokemon metagross = new Pokemon(376, "Metagross",
                "Metagross tiene cuatro cerebros en total que, combinados, son capaces de resolver cálculos complicados más rápido que el mejor ordenador que haya. Metagross puede flotar en el aire si mete las patas hacia adentro.", new TipoDual(acero, psiquico));
        pokemons.add(metagross);
        Pokemon regirock = new Pokemon(377, "Regirock",
                "A Regirock lo mantuvieron encerrado y aislado hace tiempo. Dicen que, si resulta dañado en combate, se pone él mismo a buscar piedras parecidas a las suyas y se las pone para recomponerse.", roca);
        pokemons.add(regirock);
        Pokemon regice = new Pokemon(378, "Regice",
                "Regice surgió durante la edad de hielo. El cuerpo de este Pokémon está totalmente congelado, ni siquiera el fuego puede derretirlo. Regice libera y regula un aire gélido de -200 °C.", hielo);
        pokemons.add(regice);
        Pokemon registeel = new Pokemon(379, "Registeel",
                "No hay metal que supere en dureza el cuerpo de Registeel, que tiene aspecto de estar hueco. Nadie sabe de qué se alimenta este Pokémon.", acero);
        pokemons.add(registeel);
        Pokemon latias = new Pokemon(380, "Latias",
                "Latias es muy sensible a los sentimientos de la gente. Si detecta algún ápice de hostilidad, desplegará las plumas que tiene por todo el cuerpo y se pondrá a chillar para intimidar al enemigo.", new TipoDual(dragon, psiquico));
        pokemons.add(latias);
        Pokemon latios = new Pokemon(381, "Latios",
                "Latios tiene la habilidad de hacer que los demás vean algo que él ha visto o imaginado. Este Pokémon es muy inteligente. Es capaz de entender el lenguaje humano.", new TipoDual(dragon, psiquico));
        pokemons.add(latios);
        Pokemon kyogre = new Pokemon(382, "Kyogre",
                "Kyogre se sirve de la energía de la naturaleza para realizar su Regresión Primigenia y recobrar su apariencia primitiva. Con tal poder, puede desencadenar tempestades para expandir los océanos.", agua);
        pokemons.add(kyogre);
        Pokemon groudoun = new Pokemon(383, "Groudoun",
                "A Groudon siempre se le ha descrito como el Pokémon que expandió los continentes. Varias leyendas cuentan que libró combates contra Kyogre en repetidas ocasiones para tener el control de la energía de la naturaleza.", tierra);
        pokemons.add(groudoun);
        Pokemon rayquaza = new Pokemon(384, "Rayquaza",
                "Dicen que Rayquaza ha vivido durante millones de años. Las leyendas cuentan que puso fin al continuo enfrentamiento entre Groudon y Kyogre.", new TipoDual(dragon, volador));
        pokemons.add(rayquaza);
        Pokemon jirachi = new Pokemon(385, "Jirachi",
                "Cuenta la leyenda que Jirachi hará realidad cualquier deseo que se le escriba en las notas que lleva en la cabeza cuando las lea tras salir de su letargo. Si este Pokémon siente peligro, luchará sin haber llegado a despertarse.", new TipoDual(acero, psiquico));
        pokemons.add(jirachi);
        Pokemon deoxys = new Pokemon(386, "Deoxys",
                "Tras estar expuesto a un rayo láser, el ADN de un virus espacial sufrió una mutación y dio origen a Deoxys. Según parece, el órgano cristalino que este Pokémon tiene en el torso es el cerebro.", psiquico);
        pokemons.add(deoxys);*/


        return pokemons;
    }

    public void runPokedex(View view) {
        startActivity(new Intent(this, PokedexActivity.class));
    }

    public void runFicha(View view){
        startActivity(new Intent(this, FichaActivity.class));
    }

    public void runQuizz(View view) { startActivity(new Intent(this, QuizzActivity.class));
    }
}