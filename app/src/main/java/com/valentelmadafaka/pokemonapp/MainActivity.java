package com.valentelmadafaka.pokemonapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.valentelmadafaka.pokemonapp.model.Pokemon;
import com.valentelmadafaka.pokemonapp.model.Tipo;
import com.valentelmadafaka.pokemonapp.model.TipoDual;

public class MainActivity extends AppCompatActivity {

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



        Pokemon bulbasur = new Pokemon(1, "Bulbasur",
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


    }
}
