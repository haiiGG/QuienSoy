
package com.example.quiensoy

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var titulo: TextView
    private lateinit var personaje: TextView
    private lateinit var btGenerarPersonaje: Button

    private val personajes = listOf(
        "Un ornitorrinco", "Un koala", "Una serpiente", "Un gato", "Un perro", "Un pingüino", "Un tiburón", "Un dinosaurio", "Un pollo", "Un mono",
        "Un camello", "Un oso panda", "Un león", "Un tigre", "Un elefante", "Una jirafa", "Un cocodrilo", "Un pulpo", "Una medusa", "Un flamenco",
        "Un perezoso", "Un murciélago", "Un delfín", "Una ballena", "Una rana", "Un sapo", "Un erizo", "Un hámster", "Una cobaya", "Un conejo",
        "Una tortuga", "Un caracol", "Una abeja", "Una hormiga", "Una cucaracha", "Una araña", "Un escorpión", "Un zorro", "Un lobo", "Un mapache",
        "Una ardilla", "Un castor", "Un caballo", "Una vaca", "Una oveja", "Una cabra", "Un burro", "Un pavo real", "Un avestruz", "Un cuervo",

        "Ibai Llanos", "AuronPlay", "El Rubius", "TheGrefg", "IlloJuan", "DjMaRiiO", "Willyrex", "Vegetta777", "Mikecrack", "Luzu",
        "Alexby11", "Nil Ojeda", "Jordi Wild", "Xokas", "WestCOL", "JuanSGuarnizo", "Rivers", "Spreen", "Coscu", "Davo Xeneize",
        "Fernanfloo", "Luisito Comunica", "MrBeast", "PewDiePie", "IShowSpeed", "Kai Cenat", "Ninja", "Pokimane", "Quackity", "ElMariana",
        "MissaSinfonia", "AriGameplays", "Lyna", "Fargan", "Perxitaa", "Biyín", "Carola", "Zorman", "Dalas Review", "Un streamer sin dormir",

        "Taylor Swift", "Shakira", "Bad Bunny", "Rosalía", "Aitana", "Quevedo", "Karol G", "Dua Lipa", "Ariana Grande", "Lady Gaga",
        "Rihanna", "Beyoncé", "Miley Cyrus", "Billie Eilish", "Sabrina Carpenter", "Olivia Rodrigo", "Bruno Mars", "The Weeknd", "Justin Bieber", "Harry Styles",
        "Ed Sheeran", "Eminem", "Drake", "Katy Perry", "Madonna", "Michael Jackson", "Freddie Mercury", "Lola Índigo", "Melendi", "Estopa",
        "David Bisbal", "Enrique Iglesias", "Alejandro Sanz", "C. Tangana", "Nathy Peluso", "Bizarrap", "Anuel AA", "Daddy Yankee", "J Balvin", "Rauw Alejandro",
        "Peso Pluma", "Feid", "Camilo", "Becky G", "Jennifer Lopez", "Adele", "Luis Miguel", "Chayanne", "Un cantante de ópera", "Un DJ famoso",

        "Zendaya", "Tom Holland", "Leonardo DiCaprio", "Brad Pitt", "Angelina Jolie", "Johnny Depp", "Jim Carrey", "Dwayne Johnson", "Ryan Reynolds", "Ryan Gosling",
        "Emma Watson", "Daniel Radcliffe", "Margot Robbie", "Jenna Ortega", "Pedro Pascal", "Keanu Reeves", "Will Smith", "Jackie Chan", "Arnold Schwarzenegger", "Tom Cruise",
        "Jennifer Aniston", "Jennifer Lawrence", "Meryl Streep", "Timothée Chalamet", "Florence Pugh", "Chris Hemsworth", "Chris Evans", "Robert Downey Jr.", "Scarlett Johansson", "Samuel L. Jackson",
        "Morgan Freeman", "Adam Sandler", "Rowan Atkinson", "Mr. Bean", "Penélope Cruz", "Antonio Banderas", "Mario Casas", "Úrsula Corberó", "Ester Expósito", "Paco León",
        "Santiago Segura", "Lola Flores", "Rosario Flores", "Paris Hilton", "Kim Kardashian", "Kylie Jenner", "Oprah Winfrey", "Gordon Ramsay", "David Beckham", "Un paparazzi",

        "Donald Trump", "Vladimir Putin", "Barack Obama", "Joe Biden", "Kamala Harris", "Emmanuel Macron", "Pedro Sánchez", "Mariano Rajoy", "José María Aznar", "Felipe González",
        "Isabel Díaz Ayuso", "Ada Colau", "Pablo Iglesias", "Santiago Abascal", "Yolanda Díaz", "Carles Puigdemont", "Alberto Núñez Feijóo", "Javier Milei", "Cristina Fernández de Kirchner", "Andrés Manuel López Obrador",
        "Claudia Sheinbaum", "Nayib Bukele", "Luiz Inácio Lula da Silva", "Xi Jinping", "Kim Jong-un", "Volodímir Zelenski", "Winston Churchill", "Abraham Lincoln", "George Washington", "Nelson Mandela",
        "Mahatma Gandhi", "Martin Luther King Jr.", "Cleopatra", "Julio César", "Napoleón Bonaparte", "Isabel I de Inglaterra", "Reina Victoria", "Reina Isabel II", "Carlos III", "El papa",
        "Juana de Arco", "Albert Einstein", "Marie Curie", "Leonardo da Vinci", "Isaac Newton", "Nikola Tesla", "Aristóteles", "Platón", "Sócrates", "Un alcalde en campaña",

        "Bob Esponja", "Patricio Estrella", "Calamardo", "Don Cangrejo", "Arenita Mejillas", "Mickey Mouse", "Minnie Mouse", "Donald Duck", "Goofy", "Pluto",
        "Peppa Pig", "George Pig", "Papá Pig", "Mamá Pig", "Pocoyó", "Elly", "Pato de Pocoyó", "Dora la Exploradora", "Botas", "Marshall de Paw Patrol",
        "Rubble de Paw Patrol", "Bluey", "Bingo de Bluey", "Bugs Bunny", "Pato Lucas", "Piolín", "Silvestre", "Tom", "Jerry", "Scooby-Doo",
        "Shaggy", "Velma", "Fred de Scooby-Doo", "Homer Simpson", "Marge Simpson", "Bart Simpson", "Lisa Simpson", "Maggie Simpson", "Peter Griffin", "Stewie Griffin",
        "Eric Cartman", "Kenny de South Park", "Stan de South Park", "Kyle de South Park", "Rick Sánchez", "Morty Smith", "Finn el Humano", "Jake el Perro", "Gumball Watterson", "Darwin Watterson",

        "Harry Potter", "Hermione Granger", "Ron Weasley", "Lord Voldemort", "Albus Dumbledore", "Dobby", "Hagrid", "Darth Vader", "Luke Skywalker", "Princesa Leia",
        "Yoda", "Baby Yoda", "Obi-Wan Kenobi", "Han Solo", "Indiana Jones", "Jack Sparrow", "Barbie", "Ken", "Shrek", "Burro de Shrek",
        "Fiona", "Gato con Botas", "Gru", "Los Minions", "Megamente", "Woody de Toy Story", "Buzz Lightyear", "Rex de Toy Story", "Nemo", "Dory",
        "Elsa de Frozen", "Anna de Frozen", "Olaf", "Simba", "Scar de El Rey León", "Timón", "Pumba", "Cenicienta", "Blancanieves", "Rapunzel",
        "La Sirenita", "Mulán", "Moana", "Peter Pan", "Campanilla", "Cruella de Vil", "Wednesday Addams", "Morticia Addams", "Eleven de Stranger Things", "Walter White",

        "Spider-Man", "Batman", "Superman", "Wonder Woman", "Joker", "Harley Quinn", "Iron Man", "Thor", "Hulk", "Capitán América",
        "Black Widow", "Loki", "Thanos", "Deadpool", "Wolverine", "Doctor Strange", "Black Panther", "Aquaman", "Flash", "Venom",
        "Mario Bros", "Luigi", "Princesa Peach", "Bowser", "Yoshi", "Donkey Kong", "Sonic", "Tails", "Pikachu", "Ash Ketchum",
        "Charizard", "Kirby", "Link de Zelda", "Zelda", "Lara Croft", "Pac-Man", "Steve de Minecraft", "Creeper de Minecraft", "Sans de Undertale", "Freddy Fazbear",
        "Naruto", "Goku", "Vegeta", "Sailor Moon", "Luffy de One Piece", "Zoro de One Piece", "Tanjiro Kamado", "Nezuko Kamado", "Anya Forger", "Totoro",

        "Cristiano Ronaldo", "Lionel Messi", "Neymar", "Kylian Mbappé", "Lamine Yamal", "Rafa Nadal", "Carlos Alcaraz", "Serena Williams", "Michael Jordan", "LeBron James",
        "Usain Bolt", "Fernando Alonso", "Marc Márquez", "Lewis Hamilton", "Un árbitro de fútbol", "Un entrenador enfadado", "Un comentarista deportivo", "Un portero despistado", "Un árbitro de tenis", "Un campeón olímpico",
        "Un astronauta", "Un científico loco", "Un detective", "Un médico", "Un dentista", "Un profesor de matemáticas", "Un profesor de gimnasia", "Un director de colegio", "Un policía", "Un bombero",
        "Un chef famoso", "Un camarero", "Un repartidor de pizza", "Un taxista", "Un peluquero", "Un influencer de moda", "Un modelo de pasarela", "Un mago", "Un payaso", "Un mimo",
        "Un pirata", "Un ninja", "Un vampiro", "Un hombre lobo", "Un zombie", "Un extraterrestre", "Un fantasma", "Un robot", "Un supervillano", "Un espía secreto",

        "Una patata con gafas", "Un plátano bailando", "Una tostadora cantante", "Un dinosaurio con corbata", "Un gato que paga impuestos", "Un perro influencer", "Un pato millonario", "Una gallina detective", "Un pingüino en el desierto", "Un tiburón vegetariano",
        "Un koala DJ", "Un ornitorrinco espía", "Una serpiente con sombrero", "Un pulpo malabarista", "Un caracol deportista", "Una vaca astronauta", "Un caballo que habla", "Un cerdo filósofo", "Un loro chismoso", "Una oveja rockera",
        "Un hámster culturista", "Un pez con piernas", "Un pollo ninja", "Un cactus bailarín", "Una pizza con sentimientos", "Un calcetín perdido", "Una silla con miedo", "Un microondas enfadado", "Un frigorífico cantante", "Un sofá dormilón",
        "Un profesor extraterrestre", "Un rey sin corona", "Una reina del drama", "Un millonario sin dinero", "Un detective despistado", "Un vampiro vegetariano", "Un zombie influencer", "Un fantasma tímido", "Un robot enamorado", "Un superhéroe sin poderes",
        "Un villano con miedo a la oscuridad", "Un pirata mareado", "Un ninja que hace ruido", "Un mago al que no le sale la magia", "Un chef que quema el agua", "Un cantante sin voz", "Un futbolista que no sabe correr", "Un turista perdido", "Un extraterrestre de vacaciones", "Una persona que siempre llega tarde",
    )
    private var ultimoPersonaje: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        titulo = findViewById(R.id.titulo)
        personaje = findViewById(R.id.personaje)
        btGenerarPersonaje = findViewById(R.id.btGenerarPersonaje)

        btGenerarPersonaje.setOnClickListener {
            generarPersonaje()
        }
    }

    private fun generarPersonaje() {
        var nuevoPersonaje: String

        do {
            nuevoPersonaje = personajes.random()
        } while ((personajes.size > 1) && (nuevoPersonaje == ultimoPersonaje))

        ultimoPersonaje = nuevoPersonaje

        personaje.text = nuevoPersonaje
        btGenerarPersonaje.text = getString(R.string.bt_generar_otro_personaje)
    }
}
