package com.valentelmadafaka.pokemonapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.valentelmadafaka.pokemonapp.dataBase.DBInterface;
import com.valentelmadafaka.pokemonapp.model.Pokemon;
import com.valentelmadafaka.pokemonapp.model.Tipo;
import com.valentelmadafaka.pokemonapp.model.TipoDual;

public class MainActivity extends AppCompatActivity {

    DBInterface db;
    Pokemon bulbasur;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }


    public void inicializar(){

        Tipo bicho = new Tipo(1, "bicho");
        Tipo siniestro = new Tipo(2, "siniestro");
        Tipo dragon = new Tipo(3, "dragon");
        Tipo electrico = new Tipo(4,"electrico");
        Tipo hada = new Tipo(5, "hada");
        Tipo lucha = new Tipo(6,"lucha");
        Tipo fuego = new Tipo(7, "fuego");
        Tipo volador = new Tipo(8, "volador");
        Tipo fantastma = new Tipo(9, "fantasma");
        Tipo planta = new Tipo(10, "planta");
        Tipo tierra = new Tipo(11, "tierra");
        Tipo hielo = new Tipo(12, "hielo");
        Tipo normal = new Tipo(13,"normal");
        Tipo veneno = new Tipo(14, "veneno");
        Tipo psiquico = new Tipo(15, "psiquico");
        Tipo roca = new Tipo(16, "roca");
        Tipo acero = new Tipo(17, "acero");
        Tipo agua = new Tipo(18,"agua");



        bulbasur = new Pokemon(1, "Bulbasur",
                "Puede sobrevivir largo tiempo sin probar bocado. Guarda energia en el bublo de su espalda.",new TipoDual(planta,veneno));
        Pokemon ivysaur =  new Pokemon(2, "Ivysaur",
                "Su bulbo crece cuando absorbe energía. Desprende un fuerte aroma cuando florece.", new TipoDual(planta,veneno));
        Pokemon venusaur = new Pokemon(3, "Venusaur",
                "La flor de su espalda recoge los rayos del sol. Los transforma en energía.", new TipoDual(planta,veneno));
        Pokemon charmander = new Pokemon(4, "Charmander",
                "La llama en la punta de su cola chisporrotea al arder. Sólo se oye en lugares silenciosos.", fuego);
        Pokemon charmeleon = new Pokemon(5, "Charmeleon",
                "Las duras luchas excitan a este Pokémon. Entonces, lanzará llamaradas blanco-azuladas.", fuego);
        Pokemon charizard = new Pokemon (6, "Charizard",
                "Cuando lanza una descarga de fuego súper caliente, la roja llama de su cola brilla más intensamente.", new TipoDual(fuego,volador));
        Pokemon squirtle = new Pokemon(7, "Squirtle",
                "Lanza agua a su presa desde el agua. Se esconde en su concha cuando se siente en peligro.", agua);
        Pokemon wartortle = new Pokemon(8, "Wartortle",
                "Si es golpeado, esconderá su cabeza. Aun así, su cola puede seguir golpeando.", agua);
        Pokemon blastoise = new Pokemon(9, "Blastoise",
                "Cuando ataca a un enemigo, su descarga de agua es aún más potente que una manga de bombero.", agua);
        Pokemon caterpie = new Pokemon(10, "Caterpie",
                "Si tocas los receptores de su cabeza, soltará un terrible olor para protegerse.", bicho);
        Pokemon metapod = new Pokemon(11, "Metapod",
                "Endurece su concha para protegerse. De todos modos, un gran impacto puede afectarle.", bicho);
        Pokemon butterfree = new Pokemon(12,"Butterfree",
                "Sus alas están cubiertas de polvos venenosos. Como repelen el agua, puede volar bajo la lluvia.",new TipoDual(bicho, volador));
        Pokemon weedle = new Pokemon(13, "Weedle",
                "Cuidado con el aguijón venenoso de su cabeza. Se esconde en la hierba y arbustos mientras come.", new TipoDual(bicho,veneno));
        Pokemon kakuna = new Pokemon(14,"Kakuna",
                "Sólo puede moverse un poco. Cuando está en peligro, envenena a su enemigo con su aguijón.", new TipoDual(bicho,veneno));
        Pokemon beedrill = new Pokemon(15, "Beedrill",
                "Tiene 3 aguijones venenosos en sus patas y cola. Suele pinchar a sus enemigos repetidas veces.", new TipoDual(bicho,veneno));
        Pokemon pidgey = new Pokemon(16, "Pidgey",
                "Son muy dóciles. Si son atacados, suelen lanzar arena en lugar de repeler el ataque.", new TipoDual(normal,volador));
        Pokemon pidgeotto = new Pokemon(17, "Pidgeotto",
                "Este Pokémon está repleto de vitalidad. Suele volar por su territorio en busca de presas.", new TipoDual(normal,volador));
        Pokemon pidgeot = new Pokemon(18, "Pidgeot",
                "Este Pokémon vuela a velocidad Mach 2. Sus grandes garras son armas muy peligrosas.", new TipoDual(normal,volador));
        Pokemon rattata = new Pokemon(19, "Rattata",
                "Muerde cualquier cosa con sus colmillos. Si ves uno, seguro que encuentras 40 más en la zona.", normal);
        Pokemon raticate = new Pokemon(20, "Raticate",
                "Sus patas son palmeadas. Sirven de aletas, por lo que puede nadar por ríos en busca de presa.", normal);
        Pokemon spearow = new Pokemon(21,"Spearow",
                "Es incapaz de volar a gran altura, pero es muy rápido, lo que le permite protegerse.", new TipoDual(normal,volador));
        Pokemon fearow = new Pokemon(22, "Fearow",
                "Este Pokémon es conocido desde hace muchos años. Si siente peligro volará lejos inmediatamente.", new TipoDual(normal,volador));
        Pokemon ekans = new Pokemon(23, "Ekans",
                "Cuanto más viejo, más crece este Pokémon. Por la noche, descansa en las ramas de los árboles.", veneno);
        Pokemon arbok = new Pokemon(24,"Arbok",
                "Los espantosos dibujos de su piel han sido estudiados. Seis variaciones han sido confirmadas.", veneno);
        Pokemon pikachu = new Pokemon(25, "Pikachu",
                "Mantiene su cola en alto para vigilar. Si das un tirón a su cola, querrá morderte.", electrico);
        Pokemon raichu = new Pokemon(26, "Raichu",
                "Cuando la electricidad del cuerpo crece, se vuelve irritable. También brilla en la oscuridad.", electrico);
        Pokemon sandshrew = new Pokemon(27, "Sandshrew",
                "Su cuerpo es muy seco. Cuando hace frío por la noche, su piel aparece cubierta con un fino rocío.", tierra);
        Pokemon sandslash = new Pokemon(28, "Sandslash",
                "Es muy hábil al golpear a sus enemigos con sus garras. Si se rompen, crecerán en un solo día.", tierra);
        Pokemon nidoranH = new Pokemon(29, "Nidoran♀",
                "A este Pokémon no le gusta luchar. Pero cuidado, sus pequeños cuernos segregan veneno.", veneno);
        Pokemon nidorina = new Pokemon(30, "Nidorina",
                "Cuando descansa profundamente, sus cuernos se contraen. Esto prueba que está relajado", veneno);
        Pokemon nidoqueen = new Pokemon(31, "Nidoqueen",
                "Grandes escamas recubren el duro cuerpo de este Pokémon. Éstas crecen cíclicamente.", new TipoDual(veneno, tierra));
        Pokemon nidoranM = new Pokemon(32, "Nidoran♂",
                "Sus largas orejas se mantienen siempre alerta. Si siente peligro, atacará con su venenoso cuerno.", veneno);
        Pokemon nidorino = new Pokemon(33,"Nidorino",
                "Sus cuernos contienen veneno. Si se introducen en el cuerpo del enemigo, soltarán su tóxica carga.", veneno);
        Pokemon nidoking = new Pokemon(34, "Nidoking",
            "Duro como el acero, posee una poderosa carga. Sus cuernos son tan duros como el diamante.", new TipoDual(veneno,tierra));
        Pokemon clefairy = new Pokemon(35, "Clefairy",
                "Su aspecto jovial y vivaracho lo hace adorable. Piensan que son raros, ya que no son muy comunes.", hada);
        Pokemon clefable = new Pokemon(36, "Clefable",
                "Protege bastante bien su propio entorno. Es una especie de hada, raramente vista por los humanos.", hada);
        Pokemon vulpix = new Pokemon(37, "Vulpix",
                "Su piel y colas son preciosas. Cuando crecen las colas, se dividen formando nuevas colas.", fuego);
        Pokemon ninetales = new Pokemon(38, "Ninetales",
                "De acuerdo con una antigua leyenda, este Pokémon es la reencarnación de 9 nobles santos.", fuego);
        Pokemon jigglypuff = new Pokemon(39, "Jigglypuff",
                "Utiliza sus misteriosos ojos para engañar a su enemigo. También cantará para dormirlo.", new TipoDual(normal,hada));
        Pokemon wigglytuff = new Pokemon(40, "Wigglytuff",
                "Su cuerpo es muy elástico. Cuando inhala aire profundamente, puede inflarse sin límite.", new TipoDual(normal,hada));
        Pokemon zubat = new Pokemon(41, "Zubat",
                "Emite sonidos ultrasónicos mientras vuela. Los utiliza como sónar para evitar obstáculos.", new TipoDual(veneno, volador));
        Pokemon golbat = new Pokemon(42, "Golbat",
                "Ataca de manera violenta sin avisar. Utiliza sus afilados colmillos para chupar sangre.", new TipoDual(veneno,volador));
        Pokemon oddish = new Pokemon(43, "Oddish",
                "Suele ser confundido con un puñado de semillas. Si lo extraes del suelo, gritará.", new TipoDual(planta,veneno));
        Pokemon glooom = new Pokemon(44, "Gloom",
                "¡Huele bastante mal! De todas formas, 1 de cada 1000 personas aprecian su fétido olor.", new TipoDual(planta,veneno));
        Pokemon vileplume = new Pokemon(45, "Vileplume",
                "Aletea sus pétalos de flores para propagar su venenoso polen. El sonido que emite es agudo.", new TipoDual(planta,veneno));
        Pokemon paras = new Pokemon(46, "Paras",
                "Escarba bajo el suelo para roer las raíces de los árboles. Sus setas absorben sus energías.", new TipoDual(bicho,planta));
        Pokemon parasect = new Pokemon(47, "Parasect",
                "El parásito absorbe la energía con las setas de la espalda, que lo controlan.", new TipoDual(bicho,planta));
        Pokemon venonat = new Pokemon(48, "Venonat",
                "Sus grandes ojos actúan como radares. En lugares claros, verás montones de pequeños ojos.", new TipoDual(bicho,veneno));
        Pokemon venomoth = new Pokemon(49, "Venomoth",
                "Es difícil quitar el polvo de sus alas. También posee un veneno que se desprende al contacto.", new TipoDual(bicho,veneno));
        Pokemon diglett = new Pokemon(50, "Diglett",
                "Prefiere los lugares oscuros. Pasa el tiempo bajo tierra, aunque aparece en cuevas.", tierra);
        Pokemon dugtrio = new Pokemon(51, "Dugtrio",
                "Un grupo de trillizos que cava a 90 KPH. Por ello, creen que se trata de un terremoto.", tierra);
        Pokemon meowth = new Pokemon(52,"Meowth",
                "Parece que son más activos por la noche. Adoran las cosas redondas y brillantes.", normal);
        Pokemon persian = new Pokemon(53, "Persian",
                "¡La gema en su frente brilla por sí misma! Camina con la elegancia de una reina.", normal);
        Pokemon psyduck = new Pokemon(54, "Psyduck",
                "Siempre tiene dolores de cabeza. Posee poderes mentales, pero no sabes cuándo los usará.", agua);
        Pokemon golduck = new Pokemon(55, "Golduck",
                "Sus delgados y largos miembros acaban en anchas aletas. Las usan para nadar en los lagos.", agua);
        Pokemon mankey = new Pokemon(56, "Mankey",
                "Este ágil Pokémon vive en los arboles. Se enfada fácilmente y no dudará en atacar a todos.", lucha);
        Pokemon primeapoe = new Pokemon(57,"Primeape",
                "Sólo se calma cuando nadie está cerca. Llegar a ver ese momento es realmente difícil.", lucha);
        Pokemon growlithe = new Pokemon(58, "Growlithe",
                "Este Pokémon es muy amistoso. Aun así, gruñirá a cualquiera que invada su territorio.", fuego);
        Pokemon arcanine = new Pokemon(59,"Arcanine",
                "Es un Pokémon legendario en China. Allí, adoran la gracia y belleza que exhibe al correr.", fuego);
        Pokemon poliwag = new Pokemon(60, "Poliwag",
                "La dirección de la espiral en el vientre cambia según el área. Prefiere nadar a correr.", agua);
        Pokemon poliwhirl = new Pokemon(61, "Poliwhirl",
                "Cuando lo atacan, usa la espiral del vientre para dormir al rival. Aprovecha para escapar entonces.", agua);
        Pokemon poliwrath = new Pokemon(62, "Poliwrath",
                "Es capaz de nadar usando todos los músculos de su cuerpo. Podrá adelantar incluso a un campeón.", new TipoDual(agua,lucha));
        Pokemon abra = new Pokemon(63, "Abra",
                "Duerme 18 horas al día. Si siente peligro, se teletransporta a un lugar seguro, aun durmiendo.", psiquico);
        Pokemon kadabra = new Pokemon(64, "Kadabra",
                "Muchas cosas raras suceden si está cerca. Por ejemplo, hace que los relojes vayan al revés.", psiquico);
        Pokemon alakazam = new Pokemon(65, "Alakazam",
                "Este Pokémon lo recuerda todo. Nunca olvida lo que aprende. Es un Pokémon muy listo.", psiquico);
        Pokemon machop = new Pokemon(66, "Machop",
                "Muy poderoso a pesar de su pequeño tamaño. Su maestría en artes marciales lo hace muy duro.", lucha);
        Pokemon machoke = new Pokemon(67, "Machoke",
                "El cinturón que rodea su cintura retiene toda su energía. Sin él, este Pokémon sería implacable.", lucha);
        Pokemon machamp = new Pokemon(68,"Machamp",
                "Con sólo un brazo puede mover montañas. Usando los cuatro, este Pokémon puede ser terrible.", lucha);
        Pokemon bellsprout = new Pokemon(69, "Bellsprout",
                "Prefiere los lugares calientes y húmedos. Atrapa pequeños insectos con sus ramas para devorarlos.", new TipoDual(planta,veneno));
        Pokemon weepinbell = new Pokemon(70,"Weepinbell",
                "Cuando está hambriento, ataca a todo lo que se mueva. Su pobre presa se derrite en fuertes ácidos.", new TipoDual(planta,veneno));
        Pokemon victreebel = new Pokemon(71, "Victreebel",
                "Engaña a su presa con un dulce aroma a miel. Una vez atrapada, la presa perderá hasta sus huesos.", new TipoDual(planta,veneno));
        Pokemon tentacool = new Pokemon(72,"Tentacool",
                "A veces puede ser encontrado seco y medio enterrado en una playa. Al lanzarlo otra vez al mar revivirá.", new TipoDual(agua,veneno));
        Pokemon tentacruel = new Pokemon(73, "Tentacruel",
                "Puede controlar libremente sus 80 tentáculos. Éstos debilitan a la presa con su poderoso veneno.", new TipoDual(agua,veneno));
        Pokemon geodude = new Pokemon(74,"Geodude",
                "Se encuentran normalmente en los caminos de montaña. Si te cruzas con uno, se enfadará.", new TipoDual(roca,tierra));
        Pokemon graveler = new Pokemon(75,"Graveler",
                "Se le suele ver rodando por las montañas. Los obstáculos no los evita. ¡Los arrolla!", new TipoDual(roca,tierra));
        Pokemon golem = new Pokemon(76,"Golem",
                "Cuando pierde su piel, su cuerpo se vuelve blando y blanquecino. Si esto ocurre, se esconderá.", new TipoDual(roca,tierra));
        Pokemon ponyta = new Pokemon(77, "Ponyta",
                "Es capaz de saltar muy alto. Con sus pezuñas y sus robustas patas, absorbe el impacto.", fuego);
        Pokemon rapidash = new Pokemon(78,"Rapidash",
                "Le encanta correr. Si ve algo más rápido que él, intentará alcanzarlo a toda velocidad.", fuego);
        Pokemon slowpoke = new Pokemon(79, "Slowpoke",
                "Es increíblemente lento y perezoso. Le encanta dormir sin preocuparse ni del tiempo ni de lo que ocurra.", new TipoDual(agua, psiquico));
        Pokemon slowbro = new Pokemon(80, "Slowbro",
                "Vive tranquilo en el mar. Si el Shellder de su cola se cae, vuelve a ser un Slowpoke otra vez.", new TipoDual(agua,psiquico));
        Pokemon magnemite = new Pokemon(81, "Magnemite",
                "Puede desafiar a la gravedad desde su nacimiento. Flota en el aire gracias a ondas electromagnéticas.", new TipoDual(electrico,acero));
        Pokemon magneton = new Pokemon(82, "Magneton",
                "Genera extrañas señales de radio. Es capaz de elevar la temperatura 3º centígrados.", new TipoDual(electrico,acero));
        Pokemon farfetchd = new Pokemon(83, "Farfetch'd",
                "Vive cerca de las plantas. Son raramente vistos, así que se piensa que se están extinguiendo.", new TipoDual(normal,volador));
        Pokemon doduo = new Pokemon(84, "Doduo",
                "Sus cortas alas lo hacen volar con dificultad. De todos modos, puede correr a gran velocidad.", new TipoDual(normal,volador));
        Pokemon dodrio = new Pokemon(85, "Dodrio",
                "Una de las dos cabezas de Doduo se divide para formar un nuevo PkMn. Es capaz de correr a 40 KPH.", new TipoDual(normal,volador));
        Pokemon seel = new Pokemon(86, "Seel",
                "A este Pokémon le encanta el frío. Le encanta nadar en climas polares, sea cual sea la temperatura.", agua);
        Pokemon dewgong = new Pokemon(87, "Dewgong",
                "Su cuerpo es como una bola de nieve. Inmune al frío intenso, nada rápidamente en aguas heladas.", new TipoDual(agua, hielo));
        Pokemon grimer = new Pokemon(88, "Grimer",
                "Está hecho de fango endurecido. Huele a pútrido. ¡Por donde pasa, no crece la hierba!", veneno);
        Pokemon muk = new Pokemon(89, "Muk",
                "Huele tan mal que puede provocar desmayos. Ha degenerado tanto, que ya ni él mismo se huele.", veneno);
        Pokemon shellder = new Pokemon(90, "Shellder",
                "Su concha puede evitar cualquier ataque. El débil cuerpo sólo está expuesto cuando está abierta.", agua);
        Pokemon cloyster = new Pokemon(91,"Cloyster",
                "Utiliza su concha para protegerse. Dicen que es más dura que el diamante. También lanza espinas.", new TipoDual(agua,hielo));




    }

    public void añadirVoid(View view) {
        db = new DBInterface(this);
        db.obre();
        if (db.insereixContacte(bulbasur.getNombre(), bulbasur.getDescripcion(), bulbasur.getTipoDual(), bulbasur.getTipo()) != -1) {
            Toast.makeText(this, "Afegit correctament",
                    Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Error a l’afegir",
                    Toast.LENGTH_SHORT).show();
        }
        db.tanca();
        finish();
    }
}
