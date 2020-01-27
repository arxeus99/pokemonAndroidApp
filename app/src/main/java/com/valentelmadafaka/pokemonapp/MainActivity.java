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

public class MainActivity extends AppCompatActivity {

    DBInterface db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


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

        Pokemon bulbasur = new Pokemon(1, "Bulbasur",
                "Puede sobrevivir largo tiempo sin probar bocado. Guarda energia en el bublo de su espalda.",new TipoDual(planta,veneno), "p1");
        pokemons.add(bulbasur);
        Pokemon ivysaur =  new Pokemon(2, "Ivysaur",
                "Su bulbo crece cuando absorbe energía. Desprende un fuerte aroma cuando florece.", new TipoDual(planta,veneno));
        pokemons.add(ivysaur);
        Pokemon venusaur = new Pokemon(3, "Venusaur",
                "La flor de su espalda recoge los rayos del sol. Los transforma en energía.", new TipoDual(planta,veneno));
        pokemons.add(venusaur);
        Pokemon charmander = new Pokemon(4, "Charmander",
                "La llama en la punta de su cola chisporrotea al arder. Sólo se oye en lugares silenciosos.", fuego);
        pokemons.add(charmander);
        Pokemon charmeleon = new Pokemon(5, "Charmeleon",
                "Las duras luchas excitan a este Pokémon. Entonces, lanzará llamaradas blanco-azuladas.", fuego);
        pokemons.add(charmeleon);
        Pokemon charizard = new Pokemon (6, "Charizard",
                "Cuando lanza una descarga de fuego súper caliente, la roja llama de su cola brilla más intensamente.", new TipoDual(fuego,volador));
        pokemons.add(charizard);
        Pokemon squirtle = new Pokemon(7, "Squirtle",
                "Lanza agua a su presa desde el agua. Se esconde en su concha cuando se siente en peligro.", agua);
        pokemons.add(squirtle);
        Pokemon wartortle = new Pokemon(8, "Wartortle",
                "Si es golpeado, esconderá su cabeza. Aun así, su cola puede seguir golpeando.", agua);
        pokemons.add(wartortle);
        Pokemon blastoise = new Pokemon(9, "Blastoise",
                "Cuando ataca a un enemigo, su descarga de agua es aún más potente que una manga de bombero.", agua);
        pokemons.add(blastoise);
        Pokemon caterpie = new Pokemon(10, "Caterpie",
                "Si tocas los receptores de su cabeza, soltará un terrible olor para protegerse.", bicho);
        pokemons.add(caterpie);
        Pokemon metapod = new Pokemon(11, "Metapod",
                "Endurece su concha para protegerse. De todos modos, un gran impacto puede afectarle.", bicho);
        pokemons.add(metapod);
        Pokemon butterfree = new Pokemon(12,"Butterfree",
                "Sus alas están cubiertas de polvos venenosos. Como repelen el agua, puede volar bajo la lluvia.",new TipoDual(bicho, volador));
        pokemons.add(butterfree);
        Pokemon weedle = new Pokemon(13, "Weedle",
                "Cuidado con el aguijón venenoso de su cabeza. Se esconde en la hierba y arbustos mientras come.", new TipoDual(bicho,veneno));
        pokemons.add(weedle);
        Pokemon kakuna = new Pokemon(14,"Kakuna",
                "Sólo puede moverse un poco. Cuando está en peligro, envenena a su enemigo con su aguijón.", new TipoDual(bicho,veneno));
        pokemons.add(kakuna);
        Pokemon beedrill = new Pokemon(15, "Beedrill",
                "Tiene 3 aguijones venenosos en sus patas y cola. Suele pinchar a sus enemigos repetidas veces.", new TipoDual(bicho,veneno));
        pokemons.add(beedrill);
        Pokemon pidgey = new Pokemon(16, "Pidgey",
                "Son muy dóciles. Si son atacados, suelen lanzar arena en lugar de repeler el ataque.", new TipoDual(normal,volador));
        pokemons.add(pidgey);
        Pokemon pidgeotto = new Pokemon(17, "Pidgeotto",
                "Este Pokémon está repleto de vitalidad. Suele volar por su territorio en busca de presas.", new TipoDual(normal,volador));
        pokemons.add(pidgeotto);
        Pokemon pidgeot = new Pokemon(18, "Pidgeot",
                "Este Pokémon vuela a velocidad Mach 2. Sus grandes garras son armas muy peligrosas.", new TipoDual(normal,volador));
        pokemons.add(pidgeot);
        Pokemon rattata = new Pokemon(19, "Rattata",
                "Muerde cualquier cosa con sus colmillos. Si ves uno, seguro que encuentras 40 más en la zona.", normal);
        pokemons.add(rattata);
        Pokemon raticate = new Pokemon(20, "Raticate",
                "Sus patas son palmeadas. Sirven de aletas, por lo que puede nadar por ríos en busca de presa.", normal);
        pokemons.add(raticate);
        Pokemon spearow = new Pokemon(21,"Spearow",
                "Es incapaz de volar a gran altura, pero es muy rápido, lo que le permite protegerse.", new TipoDual(normal,volador));
        pokemons.add(spearow);
        Pokemon fearow = new Pokemon(22, "Fearow",
                "Este Pokémon es conocido desde hace muchos años. Si siente peligro volará lejos inmediatamente.", new TipoDual(normal,volador));
        pokemons.add(fearow);
        Pokemon ekans = new Pokemon(23, "Ekans",
                "Cuanto más viejo, más crece este Pokémon. Por la noche, descansa en las ramas de los árboles.", veneno);
        pokemons.add(ekans);
        Pokemon arbok = new Pokemon(24,"Arbok",
                "Los espantosos dibujos de su piel han sido estudiados. Seis variaciones han sido confirmadas.", veneno);
        pokemons.add(arbok);
        Pokemon pikachu = new Pokemon(25, "Pikachu",
                "Mantiene su cola en alto para vigilar. Si das un tirón a su cola, querrá morderte.", electrico);
        pokemons.add(pikachu);
        Pokemon raichu = new Pokemon(26, "Raichu",
                "Cuando la electricidad del cuerpo crece, se vuelve irritable. También brilla en la oscuridad.", electrico);
        pokemons.add(raichu);
        Pokemon sandshrew = new Pokemon(27, "Sandshrew",
                "Su cuerpo es muy seco. Cuando hace frío por la noche, su piel aparece cubierta con un fino rocío.", tierra);
        pokemons.add(sandshrew);
        Pokemon sandslash = new Pokemon(28, "Sandslash",
                "Es muy hábil al golpear a sus enemigos con sus garras. Si se rompen, crecerán en un solo día.", tierra);
        pokemons.add(sandslash);
        Pokemon nidoranH = new Pokemon(29, "Nidoran♀",
                "A este Pokémon no le gusta luchar. Pero cuidado, sus pequeños cuernos segregan veneno.", veneno);
        pokemons.add(nidoranH);
        Pokemon nidorina = new Pokemon(30, "Nidorina",
                "Cuando descansa profundamente, sus cuernos se contraen. Esto prueba que está relajado", veneno);
        pokemons.add(nidorina);
        Pokemon nidoqueen = new Pokemon(31, "Nidoqueen",
                "Grandes escamas recubren el duro cuerpo de este Pokémon. Éstas crecen cíclicamente.", new TipoDual(veneno, tierra));
        pokemons.add(nidoqueen);
        Pokemon nidoranM = new Pokemon(32, "Nidoran♂",
                "Sus largas orejas se mantienen siempre alerta. Si siente peligro, atacará con su venenoso cuerno.", veneno);
        pokemons.add(nidoranH);
        Pokemon nidorino = new Pokemon(33,"Nidorino",
                "Sus cuernos contienen veneno. Si se introducen en el cuerpo del enemigo, soltarán su tóxica carga.", veneno);
        pokemons.add(nidorino);
        Pokemon nidoking = new Pokemon(34, "Nidoking",
                "Duro como el acero, posee una poderosa carga. Sus cuernos son tan duros como el diamante.", new TipoDual(veneno,tierra));
        pokemons.add(nidoking);
        Pokemon clefairy = new Pokemon(35, "Clefairy",
                "Su aspecto jovial y vivaracho lo hace adorable. Piensan que son raros, ya que no son muy comunes.", hada);
        pokemons.add(clefairy);
        Pokemon clefable = new Pokemon(36, "Clefable",
                "Protege bastante bien su propio entorno. Es una especie de hada, raramente vista por los humanos.", hada);
        pokemons.add(clefable);
        Pokemon vulpix = new Pokemon(37, "Vulpix",
                "Su piel y colas son preciosas. Cuando crecen las colas, se dividen formando nuevas colas.", fuego);
        pokemons.add(vulpix);
        Pokemon ninetales = new Pokemon(38, "Ninetales",
                "De acuerdo con una antigua leyenda, este Pokémon es la reencarnación de 9 nobles santos.", fuego);
        pokemons.add(ninetales);
        Pokemon jigglypuff = new Pokemon(39, "Jigglypuff",
                "Utiliza sus misteriosos ojos para engañar a su enemigo. También cantará para dormirlo.", new TipoDual(normal,hada));
        pokemons.add(jigglypuff);
        Pokemon wigglytuff = new Pokemon(40, "Wigglytuff",
                "Su cuerpo es muy elástico. Cuando inhala aire profundamente, puede inflarse sin límite.", new TipoDual(normal,hada));
        pokemons.add(wigglytuff);
        Pokemon zubat = new Pokemon(41, "Zubat",
                "Emite sonidos ultrasónicos mientras vuela. Los utiliza como sónar para evitar obstáculos.", new TipoDual(veneno, volador));
        pokemons.add(zubat);
        Pokemon golbat = new Pokemon(42, "Golbat",
                "Ataca de manera violenta sin avisar. Utiliza sus afilados colmillos para chupar sangre.", new TipoDual(veneno,volador));
        pokemons.add(golbat);
        Pokemon oddish = new Pokemon(43, "Oddish",
                "Suele ser confundido con un puñado de semillas. Si lo extraes del suelo, gritará.", new TipoDual(planta,veneno));
        pokemons.add(oddish);
        Pokemon glooom = new Pokemon(44, "Gloom",
                "¡Huele bastante mal! De todas formas, 1 de cada 1000 personas aprecian su fétido olor.", new TipoDual(planta,veneno));
        pokemons.add(glooom);
        Pokemon vileplume = new Pokemon(45, "Vileplume",
                "Aletea sus pétalos de flores para propagar su venenoso polen. El sonido que emite es agudo.", new TipoDual(planta,veneno));
        pokemons.add(vileplume);
        Pokemon paras = new Pokemon(46, "Paras",
                "Escarba bajo el suelo para roer las raíces de los árboles. Sus setas absorben sus energías.", new TipoDual(bicho,planta));
        pokemons.add(paras);
        Pokemon parasect = new Pokemon(47, "Parasect",
                "El parásito absorbe la energía con las setas de la espalda, que lo controlan.", new TipoDual(bicho,planta));
        pokemons.add(parasect);
        Pokemon venonat = new Pokemon(48, "Venonat",
                "Sus grandes ojos actúan como radares. En lugares claros, verás montones de pequeños ojos.", new TipoDual(bicho,veneno));
        pokemons.add(venonat);
        Pokemon venomoth = new Pokemon(49, "Venomoth",
                "Es difícil quitar el polvo de sus alas. También posee un veneno que se desprende al contacto.", new TipoDual(bicho,veneno));
        pokemons.add(venomoth);
        Pokemon diglett = new Pokemon(50, "Diglett",
                "Prefiere los lugares oscuros. Pasa el tiempo bajo tierra, aunque aparece en cuevas.", tierra);
        pokemons.add(diglett);
        Pokemon dugtrio = new Pokemon(51, "Dugtrio",
                "Un grupo de trillizos que cava a 90 KPH. Por ello, creen que se trata de un terremoto.", tierra);
        pokemons.add(dugtrio);
        Pokemon meowth = new Pokemon(52,"Meowth",
                "Parece que son más activos por la noche. Adoran las cosas redondas y brillantes.", normal);
        pokemons.add(meowth);
        Pokemon persian = new Pokemon(53, "Persian",
                "¡La gema en su frente brilla por sí misma! Camina con la elegancia de una reina.", normal);
        pokemons.add(persian);
        Pokemon psyduck = new Pokemon(54, "Psyduck",
                "Siempre tiene dolores de cabeza. Posee poderes mentales, pero no sabes cuándo los usará.", agua);
        pokemons.add(psyduck);
        Pokemon golduck = new Pokemon(55, "Golduck",
                "Sus delgados y largos miembros acaban en anchas aletas. Las usan para nadar en los lagos.", agua);
        pokemons.add(golduck);
        Pokemon mankey = new Pokemon(56, "Mankey",
                "Este ágil Pokémon vive en los arboles. Se enfada fácilmente y no dudará en atacar a todos.", lucha);
        pokemons.add(mankey);
        Pokemon primeapoe = new Pokemon(57,"Primeape",
                "Sólo se calma cuando nadie está cerca. Llegar a ver ese momento es realmente difícil.", lucha);
        pokemons.add(primeapoe);
        Pokemon growlithe = new Pokemon(58, "Growlithe",
                "Este Pokémon es muy amistoso. Aun así, gruñirá a cualquiera que invada su territorio.", fuego);
        pokemons.add(growlithe);
        Pokemon arcanine = new Pokemon(59,"Arcanine",
                "Es un Pokémon legendario en China. Allí, adoran la gracia y belleza que exhibe al correr.", fuego);
        pokemons.add(arcanine);
        Pokemon poliwag = new Pokemon(60, "Poliwag",
                "La dirección de la espiral en el vientre cambia según el área. Prefiere nadar a correr.", agua);
        pokemons.add(poliwag);
        Pokemon poliwhirl = new Pokemon(61, "Poliwhirl",
                "Cuando lo atacan, usa la espiral del vientre para dormir al rival. Aprovecha para escapar entonces.", agua);
        pokemons.add(poliwhirl);
        Pokemon poliwrath = new Pokemon(62, "Poliwrath",
                "Es capaz de nadar usando todos los músculos de su cuerpo. Podrá adelantar incluso a un campeón.", new TipoDual(agua,lucha));
        pokemons.add(poliwrath);
        Pokemon abra = new Pokemon(63, "Abra",
                "Duerme 18 horas al día. Si siente peligro, se teletransporta a un lugar seguro, aun durmiendo.", psiquico);
        pokemons.add(abra);
        Pokemon kadabra = new Pokemon(64, "Kadabra",
                "Muchas cosas raras suceden si está cerca. Por ejemplo, hace que los relojes vayan al revés.", psiquico);
        pokemons.add(kadabra);
        Pokemon alakazam = new Pokemon(65, "Alakazam",
                "Este Pokémon lo recuerda todo. Nunca olvida lo que aprende. Es un Pokémon muy listo.", psiquico);
        pokemons.add(alakazam);
        Pokemon machop = new Pokemon(66, "Machop",
                "Muy poderoso a pesar de su pequeño tamaño. Su maestría en artes marciales lo hace muy duro.", lucha);
        pokemons.add(machop);
        Pokemon machoke = new Pokemon(67, "Machoke",
                "El cinturón que rodea su cintura retiene toda su energía. Sin él, este Pokémon sería implacable.", lucha);
        pokemons.add(machoke);
        Pokemon machamp = new Pokemon(68,"Machamp",
                "Con sólo un brazo puede mover montañas. Usando los cuatro, este Pokémon puede ser terrible.", lucha);
        pokemons.add(machamp);
        Pokemon bellsprout = new Pokemon(69, "Bellsprout",
                "Prefiere los lugares calientes y húmedos. Atrapa pequeños insectos con sus ramas para devorarlos.", new TipoDual(planta,veneno));
        pokemons.add(bellsprout);
        Pokemon weepinbell = new Pokemon(70,"Weepinbell",
                "Cuando está hambriento, ataca a todo lo que se mueva. Su pobre presa se derrite en fuertes ácidos.", new TipoDual(planta,veneno));
        pokemons.add(weepinbell);
        Pokemon victreebel = new Pokemon(71, "Victreebel",
                "Engaña a su presa con un dulce aroma a miel. Una vez atrapada, la presa perderá hasta sus huesos.", new TipoDual(planta,veneno));
        pokemons.add(victreebel);
        Pokemon tentacool = new Pokemon(72,"Tentacool",
                "A veces puede ser encontrado seco y medio enterrado en una playa. Al lanzarlo otra vez al mar revivirá.", new TipoDual(agua,veneno));
        pokemons.add(tentacool);
        Pokemon tentacruel = new Pokemon(73, "Tentacruel",
                "Puede controlar libremente sus 80 tentáculos. Éstos debilitan a la presa con su poderoso veneno.", new TipoDual(agua,veneno));
        pokemons.add(tentacruel);
        Pokemon geodude = new Pokemon(74,"Geodude",
                "Se encuentran normalmente en los caminos de montaña. Si te cruzas con uno, se enfadará.", new TipoDual(roca,tierra));
        pokemons.add(geodude);
        Pokemon graveler = new Pokemon(75,"Graveler",
                "Se le suele ver rodando por las montañas. Los obstáculos no los evita. ¡Los arrolla!", new TipoDual(roca,tierra));
        pokemons.add(graveler);
        Pokemon golem = new Pokemon(76,"Golem",
                "Cuando pierde su piel, su cuerpo se vuelve blando y blanquecino. Si esto ocurre, se esconderá.", new TipoDual(roca,tierra));
        pokemons.add(golem);
        Pokemon ponyta = new Pokemon(77, "Ponyta",
                "Es capaz de saltar muy alto. Con sus pezuñas y sus robustas patas, absorbe el impacto.", fuego);
        pokemons.add(ponyta);
        Pokemon rapidash = new Pokemon(78,"Rapidash",
                "Le encanta correr. Si ve algo más rápido que él, intentará alcanzarlo a toda velocidad.", fuego);
        pokemons.add(rapidash);
        Pokemon slowpoke = new Pokemon(79, "Slowpoke",
                "Es increíblemente lento y perezoso. Le encanta dormir sin preocuparse ni del tiempo ni de lo que ocurra.", new TipoDual(agua, psiquico));
        pokemons.add(slowpoke);
        Pokemon slowbro = new Pokemon(80, "Slowbro",
                "Vive tranquilo en el mar. Si el Shellder de su cola se cae, vuelve a ser un Slowpoke otra vez.", new TipoDual(agua,psiquico));
        pokemons.add(slowbro);
        Pokemon magnemite = new Pokemon(81, "Magnemite",
                "Puede desafiar a la gravedad desde su nacimiento. Flota en el aire gracias a ondas electromagnéticas.", new TipoDual(electrico,acero));
        pokemons.add(magnemite);
        Pokemon magneton = new Pokemon(82, "Magneton",
                "Genera extrañas señales de radio. Es capaz de elevar la temperatura 3º centígrados.", new TipoDual(electrico,acero));
        pokemons.add(magneton);
        Pokemon farfetchd = new Pokemon(83, "Farfetch'd",
                "Vive cerca de las plantas. Son raramente vistos, así que se piensa que se están extinguiendo.", new TipoDual(normal,volador));
        pokemons.add(farfetchd);
        Pokemon doduo = new Pokemon(84, "Doduo",
                "Sus cortas alas lo hacen volar con dificultad. De todos modos, puede correr a gran velocidad.", new TipoDual(normal,volador));
        pokemons.add(doduo);
        Pokemon dodrio = new Pokemon(85, "Dodrio",
                "Una de las dos cabezas de Doduo se divide para formar un nuevo PkMn. Es capaz de correr a 40 KPH.", new TipoDual(normal,volador));
        pokemons.add(dodrio);
        Pokemon seel = new Pokemon(86, "Seel",
                "A este Pokémon le encanta el frío. Le encanta nadar en climas polares, sea cual sea la temperatura.", agua);
        pokemons.add(seel);
        Pokemon dewgong = new Pokemon(87, "Dewgong",
                "Su cuerpo es como una bola de nieve. Inmune al frío intenso, nada rápidamente en aguas heladas.", new TipoDual(agua, hielo));
        pokemons.add(dewgong);
        Pokemon grimer = new Pokemon(88, "Grimer",
                "Está hecho de fango endurecido. Huele a pútrido. ¡Por donde pasa, no crece la hierba!", veneno);
        pokemons.add(grimer);
        Pokemon muk = new Pokemon(89, "Muk",
                "Huele tan mal que puede provocar desmayos. Ha degenerado tanto, que ya ni él mismo se huele.", veneno);
        pokemons.add(muk);
        Pokemon shellder = new Pokemon(90, "Shellder",
                "Su concha puede evitar cualquier ataque. El débil cuerpo sólo está expuesto cuando está abierta.", agua);
        pokemons.add(shellder);
        Pokemon cloyster = new Pokemon(91,"Cloyster",
                "Utiliza su concha para protegerse. Dicen que es más dura que el diamante. También lanza espinas.", new TipoDual(agua,hielo));
        pokemons.add(cloyster);
        Pokemon gastly = new Pokemon(92,"Gastly",
                "Solo aparece en edificios en ruinas. No tiene forma real, ya que parece que está hecho de gas.", new TipoDual(fantastma,veneno));
        pokemons.add(gastly);
        Pokemon haunter = new Pokemon(93,"Haunter",
                "Toma la vida de su adversario a lengüetazos. Esto produce mareos hasta que la víctima fallece.", new TipoDual(fantastma,veneno));
        pokemons.add(haunter);
        Pokemon gengar = new Pokemon(94,"Gengar",
                "Sabrás que un Gengar está cerca cuando sufras de sudores fríos. Intentará echarte un hechizo.", new TipoDual(fantastma,veneno));
        pokemons.add(gengar);
        Pokemon onix = new Pokemon(95,"Onix",
                "Cava a gran velocidad en busca de comida. Los túneles que deja son usados por los Diglett.", new TipoDual(roca,tierra));
        pokemons.add(onix);
        Pokemon drowzee = new Pokemon(96,"Drowzee",
                "Si duermes cerca de uno todo el tiempo, en alguna ocasión podrás ver sueños que se haya comido antes.", psiquico);
        pokemons.add(drowzee);
        Pokemon hypno = new Pokemon(97,"Hypno",
                "Intenta evitar cualquier tipo de contacto visual con este Pokémon. Puede hipnotizar con su péndulo.", psiquico);
        pokemons.add(hypno);
        Pokemon krabby = new Pokemon(98,"Krabby",
                "Sus pinzas son armas perfectas. En alguna ocasión pueden romperse en combate, pero crecerán rápido.", agua);
        pokemons.add(krabby);
        Pokemon klinger = new Pokemon(99,"Klinger",
                "Una de sus pinzas crece más que la otra, y es dura como el acero. De todos modos, pesa demasiado.", agua);
        pokemons.add(klinger);
        Pokemon voltorb = new Pokemon(100,"Voltorb",
                "Se dice que se camufla como una Poké Ball. Al más mínimo estímulo se autodestruirá.", electrico);
        pokemons.add(voltorb);
        Pokemon electrode = new Pokemon(101,"Electrode",
                "Almacena energía eléctrica en su cuerpo. El más leve shock puede provocar una gran explosión.",electrico);
        pokemons.add(electrode);
        Pokemon exeggcute = new Pokemon(102,"Exeggcute",
                "Sus cabezas se atraen unas a otras, y giran entre sí. Debe tener seis para equilibrarse.", new TipoDual(planta,psiquico));
        pokemons.add(exeggcute);
        Pokemon exeggutor = new Pokemon(103,"Exeggutor",
                "Este Pokémon es muy ruidoso. Esto es debido a que cada una de sus cabezas hace lo que quiere.", new TipoDual(planta,psiquico));
        pokemons.add(exeggutor);
        Pokemon cubone = new Pokemon(104,"Cubone",
                "Siempre lleva el cráneo de su difunta madre. Su grito hace eco y parece una triste melodía.", tierra);
        pokemons.add(cubone);
        Pokemon marowak = new Pokemon(105,"Marowak",
                "Pequeño y débil, este Pokémon siempre va acompañado de su palo de hueso de Pokémon.", tierra);
        pokemons.add(marowak);
        Pokemon hitmonlee = new Pokemon(106,"Hitmonlee",
                "Cuando da patadas al enemigo, la planta de sus pies se vuelve tan dura como el diamante.", lucha);
        pokemons.add(hitmonlee);
        Pokemon hitmonchan = new Pokemon(107,"Hitmonchan",
                "Sus golpes se asemejan a una taladradora. Puede atravesar un muro de hormigón como si nada.", lucha);
        pokemons.add(hitmonchan);
        Pokemon lickitung = new Pokemon(108,"Lickitung",
                "Su lengua mide casi dos metros y se mueve libremente. Sus lametazos pueden causar parálisis.", normal);
        pokemons.add(lickitung);
        Pokemon koffing = new Pokemon(109,"Koffing",
                "A veces puede explotar sin avisar, ya que en lugares calurosos su gas interno se expande.", veneno);
        pokemons.add(koffing);
        Pokemon weezing = new Pokemon(110,"Weezing",
                "Este Pokémon vive absorbiendo gases venenosos, gérmenes, y el polvo que existe en la basura.", veneno);
        pokemons.add(weezing);
        Pokemon rhyhorn = new Pokemon(111,"Rhyhorn",
                "Este Pokémon no tiene muchas luces. Una vez inicia la carga, no para hasta que cae dormido.", new TipoDual(tierra,roca));
        pokemons.add(rhyhorn);
        Pokemon rhydon = new Pokemon(112,"Rhydon",
                "Camina sobre sus patas traseras, y muestra signos de inteligencia. Es capaz de aguantar lava hirviendo.", new TipoDual(tierra,roca));
        pokemons.add(rhydon);
        Pokemon chansey = new Pokemon(113,"Chansey",
                "Este amable Pokémon es capaz de compartir sus nutrientes huevos con un Pokémon herido.", normal);
        pokemons.add(chansey);
        Pokemon tangela = new Pokemon(114,"Tangela",
                "Se camufla tras una gran masa de enredaderas azules. Se dice que nunca dejan de crecer.", planta);
        pokemons.add(tangela);
        Pokemon kangaskhan = new Pokemon(115,"Kangaskhan",
                "Cuida de su cría en la bolsa de su tripa. No evitará ninguna pelea para protegerla.", normal);
        pokemons.add(kangaskhan);
        Pokemon horsea = new Pokemon(116,"Horsea",
                "Si se siente en peligro, arrojará un potente chorro de agua, o de una tinta especial, por su boca.", agua);
        pokemons.add(horsea);
        Pokemon seadra = new Pokemon(117,"Seadra",
                "Tocar su aleta trasera causa parálisis. Se engancha al coral para mantenerse mientras duerme.", agua);
        pokemons.add(seadra);
        Pokemon goldeen = new Pokemon(118,"Goldeen",
                "En su época de puesta de huevos, suelen ser vistos nadando por ríos contracorriente en grandes grupos.", agua);
        pokemons.add(goldeen);
        Pokemon seaking = new Pokemon(119,"Seaking",
                "Este Pokémon hace sus nidos tallando cantos de riachuelo con el cuerno de su cabeza.", agua);
        pokemons.add(seaking);
        Pokemon staryu = new Pokemon(120,"Staryu",
                "Mientras Su parte central se mantenga intacta, crecerá de nuevo aunque haya sido destrozado.", agua);
        pokemons.add(staryu);
        Pokemon starmie = new Pokemon(121,"Starmie",
                "Su zona central es conocida como el núcleo. Se piensa que se comunica mediante colores", new TipoDual(agua,psiquico));
        pokemons.add(starmie);
        Pokemon mr_mime = new Pokemon(122,"Mr.Mime",
                "Siempre practica la misma pantomima. Hace creer al enemigo que existe algo que no es real.", new TipoDual(psiquico,hada));
        pokemons.add(mr_mime);
        Pokemon scyther = new Pokemon(123,"Scyther",
                "Se agazapa en la hierba alta para saltar sobre su enemigo con sus guadañas. Se mueve como un ninja.", new TipoDual(bicho,volador));
        pokemons.add(scyther);
        Pokemon jynx = new Pokemon(124,"Jynx",
                "Parece moverse como si estuviera bailando un ritmo de su propia creación. Menea mucho sus caderas.", new TipoDual(hielo,psiquico));
        pokemons.add(jynx);
        Pokemon electabuzz = new Pokemon(125,"Electabuzz",
                "Cuando hay un apagón, es más que posible que este Pokémon se haya comido la energía.", electrico);
        pokemons.add(electabuzz);
        Pokemon magmar = new Pokemon(126,"Magmar",
                "Nacen en volcanes activos. Su cuerpo parece una gran bola de fuego ya que están en llamas.", fuego);
        pokemons.add(magmar);
        Pokemon pinsir = new Pokemon(127,"Pinsir",
                "Atrapa a su presa con sus pinzas, y aprieta fuerte. No se puede mover si hace mucho frío.", bicho);
        pokemons.add(pinsir);
        Pokemon tauros = new Pokemon(128,"Tauros",
                "Un rudo Pokémon repleto de energía vital. Cuando corre, no para hasta que choca con algo.", normal);
        pokemons.add(tauros);
        Pokemon magikarp = new Pokemon(129,"Magikarp",
                "Famoso por ser poco fiable. Puede encontrarse nadando en mares, lagos, ríos y charcos", agua);
        pokemons.add(magikarp);
        Pokemon gyarados = new Pokemon(130,"Gyarados",
                "Este Pokémon es enormemente destructivo. En la antigüedad, era conocido por destruir ciudades.", new TipoDual(agua,volador));
        pokemons.add(gyarados);
        Pokemon lapras = new Pokemon(131,"Lapras",
                "PEste espíritu gentil es capaz de leer la mente. Puede llevar a la gente a través del mar.", new TipoDual(agua,hielo));
        pokemons.add(lapras);
        Pokemon ditto = new Pokemon(132,"Ditto",
                "Cuando se fija en un enemigo, su cuerpo se transforma en una copia perfecta del mismo.", normal);
        pokemons.add(ditto);
        Pokemon eevee = new Pokemon(133,"Eevee",
                "Su código genético es muy inestable. Puede evolucionar en diversas razas de Pokémon.", normal);
        pokemons.add(eevee);
        Pokemon vaporeon = new Pokemon(134,"Vaporeon",
                "Su estructura celular se parece a las moléculas de agua. Es invisible cuando está en el agua", agua);
        pokemons.add(vaporeon);
        Pokemon jolteon = new Pokemon(135,"Jolteon",
                "Un Pokémon muy sensible. Se entristece o enfada con mucha facilidad, lo que le da energía.", electrico);
        pokemons.add(jolteon);
        Pokemon flareon = new Pokemon(136,"Flareon",
                "El cuerpo de este Pokémon posee una cámara ígnea. Cuando exhala aire, éste está a 3.000º Celsius.", fuego);
        pokemons.add(flareon);
        Pokemon porygon = new Pokemon(137,"Porygon",
                "La gente dice que se trata del único Pokémon que puede volar por el espacio. Aún no lo ha logrado.", normal);
        pokemons.add(porygon);
        Pokemon omanyte = new Pokemon(138,"Omanyte",
                "Este antiguo Pokémon fue recuperado de un fósil. Nada muy bien gracias al movimiento de sus 10 tentáculos.", new TipoDual(roca,agua));
        pokemons.add(omanyte);
        Pokemon omastar = new Pokemon(139,"Omastar",
                "Picos afilados rodean su boca.Su concha es demasiado grande como para que se mueva libremente.", new TipoDual(roca,agua));
        pokemons.add(omastar);
        Pokemon kabuto = new Pokemon(140,"Kabuto",
                "Este Pokémon fue recuperado desde un fósil. Usa los ojos de su espalda al ocultarse en el lecho marino.", new TipoDual(roca,agua));
        pokemons.add(kabuto);
        Pokemon kabutops = new Pokemon(141,"Kabutops",
                "Este Pokémon es un hábil y rápido nadador. Atrapa a su presa para drenar sus fluidos vitales.", new TipoDual(roca,agua));
        pokemons.add(kabutops);
        Pokemon aerodactyl = new Pokemon(142,"Aerodactyl",
                "Este Pokémon salvaje, extinto hace siglos, fue resucitado usando ADN tomado de un ámbar.", new TipoDual(roca,volador));
        pokemons.add(aerodactyl);
        Pokemon snorlax = new Pokemon(143,"Snorlax",
                "Come cualquier cosa. Incluso la comida pasada de fecha. Su estómago nunca se llena.", normal);
        pokemons.add(snorlax);
        Pokemon articuno = new Pokemon(144,"Articuno",
                "Un legendario pájaro Pokémon. Congela el agua que encuentra en el aire para generar nieve.", new TipoDual(hielo,volador));
        pokemons.add(articuno);
        Pokemon zapdos = new Pokemon(145,"Zapdos",
                "ste legendario pájaro Pokémon sólo aparece cuando el cielo se torna oscuro y caen rayos.", new TipoDual(electrico,volador));
        pokemons.add(zapdos);
        Pokemon moltres = new Pokemon(146,"Moltres",
                "Un legendario pájaro Pokémon. Cuando aletea sus flamígeras alas, la oscura noche se torna roja.", new TipoDual(fuego,volador));
        pokemons.add(moltres);
        Pokemon dratini = new Pokemon(147,"Dratini",
                "La existencia de este Pokémon ha sido confirmada recientemente por un pescador que cogió uno.", dragon);
        pokemons.add(dratini);
        Pokemon dragonair = new Pokemon(148,"Dragonair",
                "De acuerdo con un testigo, un aura de extraña forma lo rodea, dándole un misterioso y místico aspecto.", dragon);
        pokemons.add(dragonair);
        Pokemon dragonite = new Pokemon(149,"Dragonite",
                "Se dice que este Pokémon vive en algún lugar del mar, y que vuela. De todos modos, sólo es un rumor.", new TipoDual(dragon,volador));
        pokemons.add(dragonite);
        Pokemon mewtwo = new Pokemon(150,"MewTwo",
                "Su ADN es casi el mismo que el de Mew. De todos modos, su tamaño y disposición son diferentes.", psiquico);
        pokemons.add(mewtwo);
        Pokemon mew = new Pokemon(151,"Mew",
                "Cuando es mirado a través de un microscopio, puede observarse el delicado pelo de este Pokémon.", psiquico);
        pokemons.add(mew);

        return pokemons;
    }

    public void runPokedex(View view) {
        startActivity(new Intent(this, PokedexActivity.class));
    }
}
