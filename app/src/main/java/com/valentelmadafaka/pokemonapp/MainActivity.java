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
                if (db.insereixPokemon(p.getNombre(), p.getDescripcion(), p.getTipoDual(), p.getTipo(), p.getImg(), p.getImgg()) == -1) {
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

        Pokemon bulbasur = new Pokemon(1, "Bulbasur",
                "Puede sobrevivir largo tiempo sin probar bocado. Guarda energia en el bublo de su espalda.",new TipoDual(planta,veneno));
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
        Pokemon chikorita = new Pokemon(152, "Chikorita",
                "Al luchar, Chikorita agita la hoja que tiene para mantener a raya al rival. Pero, al mismo tiempo, libera una suave fragancia que apacigua el encuentro y crea un ambiente agradable y de amistad.", planta);
        pokemons.add(chikorita);
        Pokemon bayleef = new Pokemon(153, "Bayleef",
                "Bayleef tiene un collar de hojas alrededor del cuello y un brote de un árbol en cada una de ellas. La fragancia que desprenden estos brotes anima a la gente.", planta);
        pokemons.add(bayleef);
        Pokemon meganium = new Pokemon(154, "Meganium",
                "La fragancia de la flor de Meganium aplaca y suaviza los ánimos. Al luchar, este Pokémon libera mayor cantidad de esencia para disminuir el ánimo de combate de su oponente.", planta);
        pokemons.add(meganium);
        Pokemon cyndaquil = new Pokemon(155, "Cyndaquil",
                "Cyndaquil se protege soltando llamas por el lomo. Cuando está enfadado, las llamas son fieras, pero, si está cansado, solo consigue echar algunas chispas que no llegan a cuajar en una completa combustión.", fuego);
        pokemons.add(cyndaquil);
        Pokemon quilava = new Pokemon(156, "Quilava",
                "Quilava mantiene a sus rivales a raya con la intensidad de sus llamas y las ráfagas de aire ígneo que producen. También aprovecha su espectacular agilidad para esquivar ataques a la vez que abrasa al rival con sus llamas.", fuego);
        pokemons.add(quilava);
        Pokemon typhlosion = new Pokemon(157, "Typhlosion",
                "Typhlosion se oculta tras un trémulo haz de calor que crea mediante sus intensas y sofocantes llamaradas. Este Pokémon causa explosiones de fuego que reducen todo a cenizas.", fuego);
        pokemons.add(typhlosion);
        Pokemon totodile = new Pokemon(158, "Totodile",
                "Totodile tiene cuerpo pequeño, pero fuertes mandíbulas. A veces, piensa que solo está dando un mordisquito y hace unas heridas bastante considerables.", agua);
        pokemons.add(totodile);
        Pokemon croconaw = new Pokemon(159, "Croconaw",
                "Una vez que Croconaw le ha clavado los colmillos a su presa, es imposible que escape porque los tiene hacia adentro como si fueran anzuelos. Cuando Croconaw hinca los dientes, no hay escapatoria.", agua);
        pokemons.add(croconaw);
        Pokemon feraligatr = new Pokemon(160, "Feraligatr",
                "Feraligatr intimida a sus oponentes abriendo las grandes fauces que tiene. En combate, golpea el suelo bruscamente con las gruesas y fuertes patas traseras que tiene para cargar contra su rival a una velocidad de vértigo.", agua);
        pokemons.add(feraligatr);
        Pokemon sentret = new Pokemon(161, "Sentret",
                "Sentret no duerme a menos que otro haga guardia. El que hace de centinela lo despertará al mínimo signo de peligro. Cuando este Pokémon se separa de su manada, es incapaz de echarse a dormir, presa del miedo.", normal);
        pokemons.add(sentret);
        Pokemon furret = new Pokemon(162, "Furret",
                "Furret es de constitución muy delgada. En combate le resulta útil porque puede escabullirse con habilidad por cualquier huequito y escapar. A pesar de que tiene patas cortas, es ágil y veloz.", normal);
        pokemons.add(furret);
        Pokemon hoothoot = new Pokemon(163, "Hoothoot",
                "Hoothoot tiene un órgano interno que identifica y percibe la rotación de la tierra. Gracias a este órgano, el Pokémon ulula todos los días a la misma hora.", new TipoDual(normal,volador));
        pokemons.add(hoothoot);
        Pokemon noctowl = new Pokemon(164, "Noctowl",
                "Noctowl no falla a la hora de cazar a su presa en la oscuridad. El éxito se lo debe a una vista privilegiada, que le permite ver donde apenas hay luz, y a las ligeras y flexibles alas que tiene, que no hacen ruido alguno al volar.", new TipoDual(normal, volador));
        pokemons.add(noctowl);
        Pokemon ledyba = new Pokemon(165, "Ledyba",
                "Ledyba segrega un fluido aromático por los seis puntos de unión que tiene entre las patas y el cuerpo. A través de este fluido se comunica con otros y les informa acerca de sus sentimientos variando la esencia.", new TipoDual(bicho,volador));
        pokemons.add(ledyba);
        Pokemon ledian = new Pokemon(166, "Ledian",
                "Dicen que en zonas en las que el aire está limpio, en las que se ven las estrellas, hay enormes poblaciones de Ledian. La razón es muy sencilla: este Pokémon usa la luz de las estrellas como fuente de energía.", new TipoDual(bicho,volador));
        pokemons.add(ledian);
        Pokemon spinarak = new Pokemon(167, "Spinarak",
                "La tela que teje Spinarak puede considerarse como su segundo sistema nervioso. Dicen que puede adivinar qué tipo de presa ha caído en su red con solo observar las leves vibraciones de los hilos de la tela.", new TipoDual(bicho, veneno));
        pokemons.add(spinarak);
        Pokemon ariados = new Pokemon(168, "Ariados",
                "Ariados tiene unas patas con forma de garfio que le permiten correr por techos y superficies verticales. Este Pokémon oprime al rival con una tela de araña fina y resistente.", new TipoDual(bicho, veneno));
        pokemons.add(ariados);
        Pokemon crobat = new Pokemon(169, "Crobat",
                "Cuando este Pokémon vuela batiendo solo las alas delanteras o traseras, es porque lleva volando bastante tiempo. Cuando se cansa, Crobat alterna las alas.", new TipoDual(veneno, volador));
        Pokemon chinchou = new Pokemon(170, "Chinchou",
                "Chinchou libera cargas eléctricas positivas y negativas a través de las dos antenas que tiene para que su rival pierda el conocimiento. Asimismo, usa los destellos de electricidad para comunicarse con otros.", new TipoDual(agua,electrico));
        pokemons.add(chinchou);
        Pokemon lanturn = new Pokemon(171, "Lanturn",
                "A Lanturn lo llaman la Estrella del Fondo del Mar por la antena iluminada que tiene. Este Pokémon produce luz creando una reacción química entre una bacteria y los fluidos corporales de la antena.", new TipoDual(agua,veneno));
        pokemons.add(lanturn);
        Pokemon pichu = new Pokemon(172, "Pichu",
                "A Pichu le resulta más fácil cargarse de electricidad en días de nubarrones o cuando sopla un aire muy seco. Es posible oír la electricidad estática que emana de este Pokémon.", electrico);
        pokemons.add(pichu);
        Pokemon cleffa = new Pokemon(173, "Cleffa",
                "Cuando hay lluvia de estrellas, a los Cleffa se les puede ver danzando en círculos durante toda la noche. Solo paran cuando rompe el día; entonces, dejan de bailar y calman su sed con el rocío de la mañana.", hada);
        pokemons.add(cleffa);
        Pokemon igglybuff = new Pokemon(174, "Igglypuff",
                "Las cuerdas vocales de Igglybuff no están suficientemente desarrolladas. Si tuviera que cantar mucho, se haría daño en la garganta. Este Pokémon suele hacer gárgaras con agua pura de manantial.", new TipoDual(normal, hada));
        pokemons.add(igglybuff);
        Pokemon togepi = new Pokemon(175, "Togepi",
                "Togepi usa los sentimientos positivos de compasión y alegría que desprenden las personas y los Pokémon. Este Pokémon almacena sentimientos de felicidad en su interior y después los comparte con otros.", hada);
        pokemons.add(togepi);
        Pokemon togetic = new Pokemon(176, "Togetic",
                "Dicen que Togetic es un Pokémon que trae buena suerte y que, si detecta a alguien que es puro de corazón, sale para compartir su alegría con él.", new TipoDual(normal, volador));
        pokemons.add(togetic);
        Pokemon natu = new Pokemon(177, "Natu",
                "Natu no puede volar porque las alas no le han crecido lo suficiente. Si alguien cruza la mirada con él, se la devolverá fijamente, aunque, si hace el mínimo movimiento, huirá dando saltitos para ponerse a salvo.", new TipoDual(psiquico, volador));
        pokemons.add(natu);
        Pokemon xatu = new Pokemon(178, "Xatu",
                "Xatu permanece de pie inmóvil y tranquilo en el mismo sitio durante todo el día. Se cree que no se mueve por temor a lo que ha visto que ocurrirá en el futuro.", new TipoDual(psiquico, volador));
        pokemons.add(xatu);
        Pokemon mareep = new Pokemon(179,"Mareep",
                "Mareep tiene un pelaje lanudo suave que produce carga estática por el roce. Cuanto más se carga de electricidad estática, más brilla la bombilla que tiene en el extremo de la cola.", electrico);
        pokemons.add(mareep);
        Pokemon flaaffy = new Pokemon(180, "Flaaffy",
                "La calidad de la lana de Flaaffy varía para poder generar mucha electricidad estática con muy poca cantidad de lana. Las zonas suaves de la piel en las que no tiene pelaje están protegidas contra la electricidad.", electrico);
        pokemons.add(flaaffy);
        Pokemon ampharos = new Pokemon(181, "Ampharos",
                "Ampharos desprende tanta luz que es posible verle hasta desde el espacio. Antes, la gente usaba su luz como sistema de comunicación para enviarse señales.", electrico);
        pokemons.add(ampharos);
        Pokemon bellossom = new Pokemon(182, "Bellossom",
                "Cuando Bellossom se expone a gran cantidad de luz solar, le empiezan a girar las hojas que le rodean. La danza de este Pokémon es famosa en las zonas del sur.", planta);
        pokemons.add(bellossom);
        Pokemon marill = new Pokemon(183, "Marill",
                "La cola de Marill contiene un aceite que hace las veces de chaleco salvavidas. Si ves una moviéndose en el agua, seguro que debajo hay un Marill medio sumergido buscando plantas acuáticas para comer.", new TipoDual(agua,hada));
        pokemons.add(marill);
        Pokemon azumarill = new Pokemon(184, "Azumarill",
                "Azumarill puede hacer burbujas de aire si ve a algún Pokémon que esté a punto de ahogarse. Estas burbujas de aire son básicas para que los Pokémon puedan seguir respirando.", new TipoDual(agua, hada));
        pokemons.add(azumarill);
        Pokemon sudowoodo = new Pokemon(185, "Sudowoodo",
                "Sudowoodo se camufla adoptando la imagen de un árbol para que no le ataque ningún enemigo. El problema viene en invierno, ya que las extremidades superiores tienen color verde y es fácil identificarle.",  roca);
        pokemons.add(sudowoodo);
        Pokemon politoed = new Pokemon(186, "Politoed",
                "El mechón rizado de Politoed confirma su condición de rey. Dicen que cuanto más le crece y más se le riza, mayor es el respeto que recibe de sus súbditos.", agua);
        pokemons.add(politoed);
        Pokemon hoppip = new Pokemon(187, "Hoppip",
                "Este Pokémon flota en el aire y se deja llevar. Cuando percibe que el viento va a cambiar a fuerte, Hoppip entrelaza sus hojas con otros Hoppip para hacer resistencia y evitar salir volando por la fuerza de la corriente.", new TipoDual(planta, volador));
        pokemons.add(hoppip);
        Pokemon skiplooom = new Pokemon (188, "Skiploom",
                "Skiploom florece cuando la temperatura llega a 18 °C. La apertura de los pétalos varía según la temperatura que haga. Por este motivo, la gente lo usa a veces a modo de termómetro.", new TipoDual(planta,volador));
        pokemons.add(skiplooom);
        Pokemon jumpluff = new Pokemon(189, "Jumpluff",
                "Jumpluff se vale de los cálidos vientos del sur para volar a tierras lejanas. Si llega a zonas de aire frío en pleno vuelo, descenderá y tomará tierra.", new TipoDual(planta, volador));
        pokemons.add(jumpluff);
        Pokemon aipom = new Pokemon(190, "Aipom",
                "La cola de Aipom termina en una especie de mano a la que, con un poco de cabeza, se le puede dar muy buen uso. Pero hay un problema: como se ha acostumbrado a usarla mucho, las de verdad se le han vuelto algo torponas.", normal);
        pokemons.add(aipom);
        Pokemon sunkern = new Pokemon(191, "Sunkern",
                "Sunkern intenta moverse lo menos posible para conservar todos los nutrientes que ha guardado en su interior y poder evolucionar. Ni come siquiera; se alimenta solo del rocío de la mañana.", planta);
        pokemons.add(sunkern);
        Pokemon sunflora = new Pokemon(192, "Sunflora",
                "Sunflora transforma la energía solar en nutrientes. De día, cuando hace calor, está en continuo movimiento. Solo para cuando comienza a anochecer.", planta);
        pokemons.add(sunflora);
        Pokemon yanma = new Pokemon(193, "Yanma",
                "Yanma tiene un ángulo de visión de 360° sin mover los ojos. Es un gran volador, experto en hacer repentinas paradas y cambios de dirección en el aire. Aprovecha la habilidad que tiene de volar para lanzarse sobre su presa.", new TipoDual(bicho, volador));
        pokemons.add(yanma);
        Pokemon wooper = new Pokemon(194, "Wooper",
                "Wooper suele vivir en el agua, pero es posible también verle en tierra en busca de comida. Cuando está en terreno firme, se cubre con una película viscosa tóxica.", new TipoDual(agua, tierra));
        pokemons.add(wooper);
        Pokemon quagsire = new Pokemon(195, "Quagsire",
                "Quagsire caza dejando las fauces abiertas en el agua y esperando a que su presa entre sin darse cuenta. Como se queda quieto, el Pokémon no pasa mucha hambre.", new TipoDual(agua, tierra));
        pokemons.add(quagsire);
        Pokemon espeon = new Pokemon(196, "Espeon",
                "Espeon es tremendamente leal al Entrenador al que considera digno de ello. Dicen que este Pokémon desarrolló sus poderes adivinatorios para evitar que su Entrenador sufra daño alguno.", psiquico);
        pokemons.add(espeon);
        Pokemon umbreon = new Pokemon(197, "Umbreon",
                "Umbreon evolucionó tras haber estado expuesto a ondas lunares. Suele esconderse en la oscuridad en silencio y esperar a que su presa se mueva. Cuando se lanza al ataque, le brillan los anillos del cuerpo.", siniestro);
        pokemons.add(umbreon);
        Pokemon murkrow = new Pokemon(198, "Murkrow",
                "Murkrow ha sido temido y repudiado por todos por ser supuestamente fuente de mala suerte. Este Pokémon siente debilidad por todo lo que brilla y resplandece. A las mujeres les roba los anillos.", new TipoDual(siniestro, volador));
        pokemons.add(murkrow);
        Pokemon slowking = new Pokemon(199, "Slowking",
                "Slowking dedica cada día tiempo a investigar, en un intento por resolver los misterios del mundo. Aunque, según parece, a este Pokémon se le olvida todo lo que ha aprendido si se separa del Shellder que lleva en la cabeza.", new TipoDual(agua, psiquico));
        pokemons.add(slowking);
        Pokemon misdreavus = new Pokemon(200, "Misdreavus",
                "Misdreavus asusta a la gente con un chillido escalofriante y sollozante. Y, al parecer, usa las esferas rojas para absorber los sentimientos de miedo de los enemigos y usarlos como alimento.", fantastma);
        pokemons.add(misdreavus);
        Pokemon unown = new Pokemon(201, "Unown",
                "Estos Pokémon tienen forma de caracteres antiguos. No se sabe qué surgió primero, si la vieja escritura o los distintos Unown. Esta cuestión sigue siendo objeto de estudio, pero aún no se ha averiguado nada.", psiquico);
        pokemons.add(unown);
        Pokemon wobbuffet = new Pokemon(202, "Wobbuffet",
                "Si dos o más Wobbuffet se encuentran, se volverán competitivos e intentarán superarse en resistencia. Pero también puede que intenten aguantar sin comer; algo que los Entrenadores deben tener muy en cuenta.", psiquico);
        pokemons.add(wobbuffet);
        Pokemon girafarig = new Pokemon(203, "Girafarig",
                "Girafarig tiene un cerebro también en la cabeza de la cola que reacciona atacando ante olores y sonidos. Cuando alguien se acerca a este Pokémon por la espalda, puede provocar que la cabeza trasera se abalance y lo muerda.", new TipoDual(normal,psiquico));
        pokemons.add(girafarig);
        Pokemon pineco = new Pokemon(204, "Pineco",
                "Pineco permanece colgado de la rama de un árbol esperando pacientemente a su presa. Si alguien sacude el árbol en el que está mientras come y le molesta, se tira al suelo y explota sin dar ningún tipo de aviso.", bicho);
        pokemons.add(pineco);
        Pokemon forrefest = new Pokemon(205, "Forrefest",
                "Forretress se esconde dentro de su concha de acero reforzada. Solo la abre cuando va a atrapar a su presa, pero ocurre tan rápido que no da tiempo de ver su interior.", new TipoDual(bicho, acero));
        pokemons.add(forrefest);
        Pokemon dunsparce =  new Pokemon(206, "Dusnparce",
                "La cola de Dunsparce es un taladro que usa para enterrarse en el suelo de espaldas. De todos es sabido que este Pokémon hace su nido a gran profundidad y con una forma muy compleja.", normal);
        pokemons.add(dunsparce);
        Pokemon gligar = new Pokemon(207, "Gligar",
                "Gligar planea por el aire sin hacer ningún ruido, como si fuera patinando. Este Pokémon se agarra a la cara de su rival con las patas traseras, con forma de garra, y las pinzas de las delanteras y le inyecta veneno por el aguijón.", new TipoDual(tierra, volador));
        pokemons.add(gligar);
        Pokemon steelix = new Pokemon(208, "Steelix",
                "Steelix vive a mayor profundidad aún que Onix. Se le conoce por su tendencia a excavar hacia el interior del planeta. Hay datos que muestran que este Pokémon ha llegado a alcanzar 1 km de profundidad.", new TipoDual(acero, tierra));
        pokemons.add(steelix);
        Pokemon snubbull = new Pokemon(209, "Snubbull",
                "Al tener los colmillos por fuera, Snubbull da miedo y espanta a los Pokémon pequeños, que huyen aterrados. Parece que a él le da un poco de pena que salgan huyendo.", hada);
        pokemons.add(snubbull);
        Pokemon grandbull = new Pokemon(210, "Grandbull",
                "Granbull tiene la mandíbula inferior demasiado desarrollada y colmillos enormes y pesados que le obligan a inclinar la cabeza hacia atrás para compensar el peso. Si no se le asusta, no muerde.", hada);
        pokemons.add(grandbull);
        Pokemon qwilfish  = new Pokemon(211, "Qwilfish",
                "Qwilfish bebe agua y se hincha, y a continuación usa la presión del agua que ha tragado para lanzar púas tóxicas por todo el cuerpo. Para este Pokémon nadar es una especie de desafío.", new TipoDual(agua,veneno));
        pokemons.add(qwilfish);
        Pokemon scizor = new Pokemon(212, "Scizor",
                "Scizor tiene un cuerpo duro como el acero que no es fácil de alterar con ningún ataque común. Este Pokémon bate las alas para regular la temperatura corporal.", new TipoDual(bicho, acero));
        pokemons.add(scizor);
        Pokemon shuckle = new Pokemon(213, "Shuckle",
                "Shuckle permanece escondido bajo las rocas en silencio y, cuando se pone a comer las bayas que almacena, se encierra en el caparazón. Las bayas se mezclan con sus fluidos corporales y originan zumo.", new TipoDual(bicho, roca));
        pokemons.add(shuckle);
        Pokemon heracross = new Pokemon(214, "Heracross",
                "Heracross carga en línea recta contra el enemigo, se le queda encajado por debajo, lo agarra y lo lanza con ayuda del fuerte cuerno que tiene. Este Pokémon tiene fuerza hasta para echar abajo un árbol descomunal.", new TipoDual(bicho, lucha));
        pokemons.add(heracross);
        Pokemon sneasel = new Pokemon(215, "Sneasel",
                "Sneasel trepa por los árboles agarrándose a la corteza con las garras curvas que tiene. Este Pokémon busca nidos desprovistos de vigilancia paterna para robar los huevos y comérselos.", new TipoDual(siniestro,hielo));
        pokemons.add(sneasel);
        Pokemon teddiursa = new Pokemon(216, "Teddiursa",
                "A Teddiursa le encanta chuparse las palmas impregnadas de dulce miel. Este Pokémon fabrica su propia miel mezclando frutos y el polen que recoge Beedrill.", normal);
        pokemons.add(teddiursa);
        Pokemon ursaring = new Pokemon(217, "Ursaring",
                "En los bosques habitados por Ursaring, dicen que abundan los arroyos y árboles gigantes en los que guardan su alimento. Este Pokémon se dedica todos los días a pasear por el bosque para buscar comida y guardarla.", normal);
        pokemons.add(ursaring);
        Pokemon slugma = new Pokemon(218, "Slugma",
                "Por el sistema circulatorio de Slugma corre magma líquido. Si este Pokémon se enfriara, el magma perdería el calor y se solidificaría, por lo que se resquebrajaría por completo, perdería algunos trozos y reduciría su tamaño.", fuego);
        pokemons.add(slugma);
        Pokemon magcargo = new Pokemon(219, "Magcargo",
                "La coraza de Magcargo es en realidad su propia piel que quedó endurecida al enfriarse. Está muy resquebrajada y es muy frágil; se desharía solo con tocarla. Este Pokémon debe sumergirse en magma para recuperar su forma.", new TipoDual(fuego, roca));
        pokemons.add(magcargo);
        Pokemon swinub = new Pokemon(220, "Swinub",
                "Swinub busca el alimento frotando el hocico contra el suelo. Su comida preferida es una seta que crece bajo la hierba marchita. A veces, al frotar, descubre fuentes termales.", new TipoDual(hielo, tierra));
        pokemons.add(swinub);
        Pokemon piloswine = new Pokemon(221, "Piloswine",
                "Piloswine está cubierto por un pelaje tupido y de largas cerdas que le permite soportar el frío polar. Este Pokémon usa los colmillos para desenterrar los alimentos que hayan podido quedar bajo el hielo.", new TipoDual(hielo, tierra));
        pokemons.add(piloswine);
        Pokemon corsola = new Pokemon(222, "Corsola",
                "Las ramas de Corsola brillan con belleza hasta en siete colores cuando les da el sol. Si se le rompe alguna, el Pokémon la regenera en tan solo una noche.", new TipoDual(agua, roca));
        pokemons.add(corsola);
        Pokemon remoraid = new Pokemon(223, "Remoraid",
                "Remoraid traga agua y usa los abdominales para lanzarla a gran velocidad contra una presa que esté en el aire. Cuando está a punto de evolucionar, este Pokémon nada en los ríos corriente abajo.", agua);
        pokemons.add(remoraid);
        Pokemon octillery = new Pokemon(224, "Octillery",
                "Octillery se apodera de su enemigo con los tentáculos y lo deja inmovilizado antes de propinarle el golpe final. Si el enemigo resulta ser demasiado fuerte, Octillery expulsará tinta para escapar.", agua);
        pokemons.add(octillery);
        Pokemon delibird = new Pokemon(225, "Delibird",
                "Delibird usa la cola a modo de saco para llevar su alimento. En una ocasión, un famoso escalador consiguió alcanzar la cima más alta del mundo gracias a que uno de estos Pokémon compartió sus alimentos con él.", new TipoDual(hielo, volador));
        pokemons.add(delibird);
        Pokemon mantine = new Pokemon(226, "Mantine",
                "En los días que hace sol, es posible ver bancos de Mantine saltando con elegancia por entre las olas del mar. A estos Pokémon no les molestan los Remoraid que se les pegan.", new TipoDual(agua, volador));
        pokemons.add(mantine);
        Pokemon skarmory = new Pokemon(227, "Skaromry",
                "Skarmory está totalmente encerrado en el interior de una fuerte coraza protectora. En vuelo, puede llegar a alcanzar los 300 km/h y usa las afiladas alas que tiene para azotar al rival.", new TipoDual(acero, volador));
        pokemons.add(skarmory);
        Pokemon hondour = new Pokemon(228, "Hondour",
                "Houndour sale a cazar con el resto de la manada con total coordinación. Estos Pokémon se comunican unos con otros usando una serie de aullidos para acorralar a su presa. El compañerismo que existe entre ellos es incomparable.", new TipoDual(siniestro, fuego));
        pokemons.add(hondour);
        Pokemon houndoom = new Pokemon(229, "Houndoom",
                "En la manada de Houndoom, el que tiene los cuernos más arqueados hacia atrás tiene un mayor papel de liderazgo. Estos Pokémon suelen elegir al jefe en duelo.", new TipoDual(siniestro, fuego));
        pokemons.add(houndoom);
        Pokemon kingdra = new Pokemon(230, "Kingdra",
                "Kingdra vive en lo más profundo del océano, donde no habita ninguna otra especie. Siempre se ha pensado que su bostezo causaba las corrientes en remolino que se dan en el océano.", new TipoDual(agua, dragon));
        pokemons.add(kingdra);
        Pokemon phanpy = new Pokemon(231, "Phanpy",
                "Phanpy cava un agujero profundo para hacer su nido en el suelo, en la ribera de los ríos, y marca con la trompa la zona para que el resto vea que ese terreno ya está ocupado.", tierra);
        pokemons.add(phanpy);
        Pokemon donphan = new Pokemon(232, "Donphan",
                "A Donphan le encanta enrollarse como una pelota y cargar contra el enemigo rodando a toda velocidad. Una vez que ha comenzado a rodar, no es fácil pararlo.", tierra);
        pokemons.add(donphan);
        Pokemon porygon2 = new Pokemon(233, "Porygon2",
                "Porygon2 fue creado por el hombre gracias a los avances de la ciencia. Esta obra humana ha sido provista de inteligencia artificial que le permite aprender gestos y sensaciones nuevas por su cuenta.", normal);
        pokemons.add(porygon2);
        Pokemon stantler = new Pokemon(234, "Stantler",
                "Hace tiempo, se comerciaba con la magnífica cornamenta de Stantler. Se vendía como obra de arte a alto precio. Los interesados en cornamentas de valor incalculable empezaron a cazarlos y casi provocan su extinción.", normal);
        pokemons.add(stantler);
        Pokemon smeargle = new Pokemon(235, "Smeargle",
                "Smeargle marca los límites de su territorio liberando un fluido corporal por el extremo de la cola. En la actualidad se han encontrado más de 5000 tipos de marcas distintas dejadas por este Pokémon.", normal);
        pokemons.add(smeargle);
        Pokemon tyrogue = new Pokemon(236, "Tyrogue",
                "Tyrogue se pone demasiado nervioso si no lo sacan a entrenarse cada día. Su Entrenador debe establecer y mantener ciertos métodos de entrenamiento durante la cría.", lucha);
        pokemons.add(tyrogue);
        Pokemon hitmontop = new Pokemon(237, "Hitmontop",
                "Hitmontop hace el pino con la cabeza y se pone a girar rápido al tiempo que reparte patadas. Esta es una técnica ofensiva y defensiva a la vez. Este Pokémon se desplaza más rápido girando sobre sí que caminando.", lucha);
        pokemons.add(hitmontop);
        Pokemon smoochum = new Pokemon(238, "Smoochum",
                "Smoochum va corriendo por todos lados, pero se cae también con frecuencia. Y, en cuanto tiene ocasión, se mira en algún sitio para ver si se ha manchado la cara.", new TipoDual(hielo, psiquico));
        pokemons.add(smoochum);
        Pokemon elekid = new Pokemon(239, "Elekid",
                "Elekid acumula electricidad. Si entra en contacto con algo de metal y descarga accidentalmente toda la electricidad almacenada, empieza a agitar los brazos en círculo para volver a cargarse.", electrico);
        pokemons.add(elekid);
        Pokemon magby = new Pokemon(240, "Magby",
                "El estado de salud de Magby se puede determinar observando el fuego que emana al respirar. Si las llamas que echa por la boca son amarillas, está bien. Pero, si además de las llamas sale humo negro, está cansado.", fuego);
        pokemons.add(magby);
        Pokemon miltank = new Pokemon(241, "Miltank",
                "Miltank da al día 20 l de una leche dulce que es la delicia de pequeños y mayores. Aquellos que no pueden tomarla, se decantan por los yogures.", normal);
        pokemons.add(miltank);
        Pokemon blissey = new Pokemon(242, "Blissey",
                "Blissey es capaz de sentir la tristeza a través del sedoso pelaje. Si detecta que alguien está apenado, irá hasta donde esté y compartirá un Huevo Suerte para devolverle la sonrisa.", normal);
        pokemons.add(blissey);
        Pokemon raikou = new Pokemon(243, "Raikou",
                "Raikou tiene la velocidad del rayo. Los rugidos de este Pokémon emiten ondas de choque que se esparcen vibrando por el aire y sacuden el suelo como si fueran auténticas descargas de rayo.", electrico);
        pokemons.add(raikou);
        Pokemon entei = new Pokemon(244, "Entei",
                "Entei contiene el fulgor del magma en su interior. Se cree que este Pokémon nació de la erupción de un volcán. Escupe numerosas ráfagas de fuego que devoran y reducen a cenizas todo lo que tocan.", fuego);
        pokemons.add(entei);
        Pokemon suicune = new Pokemon(245, "Suicune",
                "Suicune emana la pureza de los manantiales. Suele corretear por el campo con gran elegancia. Este Pokémon tiene el poder de purificar el agua contaminada.", agua);
        pokemons.add(suicune);
        Pokemon larvitar = new Pokemon(246, "Larvitar",
                "Larvitar nace bajo tierra a gran profundidad. Para subir a la superficie, este Pokémon debe comer lo que encuentra en su camino para abrirse paso. Y, hasta que no está arriba, no puede verles la cara a sus padres.", new TipoDual(roca, tierra));
        pokemons.add(larvitar);
        Pokemon pupitar = new Pokemon(247, "Pupitar",
                "Pupitar crea un gas en su interior que comprime y expulsa violentamente a modo de autopropulsión. Tiene un cuerpo resistente que se mantiene inalterable hasta cuando se golpea contra duro acero.", new TipoDual(roca, tierra));
        pokemons.add(pupitar);
        Pokemon tyranitar = new Pokemon(248, "Tyranitar",
                "Tyranitar tiene una fuerza imponente; es capaz de echar abajo una montaña para hacer su nido. Este Pokémon suele merodear por las zonas de montaña en busca de nuevos rivales contra los que luchar.", new TipoDual(roca, siniestro));
        pokemons.add(tyranitar);
        Pokemon lugia = new Pokemon(249, "Lugia",
                "La fuerza que tiene Lugia en las alas es devastadora; con nada que las bata es capaz de derribar edificios enteros. Por eso mismo, prefiere vivir donde no haya nadie, en lo más profundo del mar.", new TipoDual(psiquico, volador));
        pokemons.add(lugia);
        Pokemon hooh = new Pokemon(250, "Ho-Oh",
                "El plumaje de Ho-Oh contiene siete colores que pueden apreciarse según el ángulo desde el que les dé la luz. Dicen que sus plumas dan felicidad a quienes las llevan y, también, que este Pokémon vive a los pies del arco iris.", new TipoDual(fuego, volador));
        pokemons.add(hooh);
        Pokemon celebi = new Pokemon(251, "Celebi",
                "Este Pokémon vino del futuro haciendo un viaje en el tiempo. Hay quien piensa que, mientras Celebi siga apareciendo, hay un futuro brillante y esperanzador.", new TipoDual(psiquico,planta));
        pokemons.add(celebi);



        return pokemons;
    }

    public void runPokedex(View view) {
        startActivity(new Intent(this, PokedexActivity.class));
    }

    public void runFicha(View view){
        startActivity(new Intent(this, FichaActivity.class));
    }
}
