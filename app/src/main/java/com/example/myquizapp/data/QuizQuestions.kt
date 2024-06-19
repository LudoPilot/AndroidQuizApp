// QuizQuestions.kt
package com.example.myquizapp.data

object QuizQuestions {

    fun getEuropeanQuestions(): List<Question> {
        return listOf(
            Question(
                "Quelle est la capitale de la France ?",
                listOf("Paris", "Madrid", "Rome", "Berlin"),
                "Paris"
            ),
            Question(
                "Quelle est la capitale de l'Allemagne ?",
                listOf("Berlin", "Vienne", "Zurich", "Hambourg"),
                "Berlin"
            ),
            Question(
                "Quelle est la capitale de l'Italie ?",
                listOf("Rome", "Milan", "Naples", "Venise"),
                "Rome"
            ),
            Question(
                "Quelle est la capitale de l'Espagne ?",
                listOf("Madrid", "Barcelone", "Valence", "Séville"),
                "Madrid"
            ),
            Question(
                "Quelle est la capitale du Portugal ?",
                listOf("Lisbonne", "Porto", "Faro", "Coimbra"),
                "Lisbonne"
            ),
            Question(
                "Quelle est la capitale de la Belgique ?",
                listOf("Bruxelles", "Anvers", "Gand", "Liège"),
                "Bruxelles"
            ),
            Question(
                "Quelle est la capitale de la Suisse ?",
                listOf("Berne", "Genève", "Zurich", "Lausanne"),
                "Berne"
            ),
            Question(
                "Quelle est la capitale des Pays-Bas ?",
                listOf("Amsterdam", "Rotterdam", "La Haye", "Utrecht"),
                "Amsterdam"
            ),
            Question(
                "Quelle est la capitale de l'Autriche ?",
                listOf("Vienne", "Salzbourg", "Innsbruck", "Graz"),
                "Vienne"
            ),
            Question(
                "Quelle est la capitale de la Suède ?",
                listOf("Stockholm", "Göteborg", "Malmö", "Uppsala"),
                "Stockholm"
            ),
            Question(
                "Quelle est la capitale de la Norvège ?",
                listOf("Oslo", "Bergen", "Trondheim", "Stavanger"),
                "Oslo"
            ),
            Question(
                "Quelle est la capitale du Danemark ?",
                listOf("Copenhague", "Aarhus", "Odense", "Aalborg"),
                "Copenhague"
            ),
            Question(
                "Quelle est la capitale de la Finlande ?",
                listOf("Helsinki", "Espoo", "Tampere", "Vantaa"),
                "Helsinki"
            ),
            Question(
                "Quelle est la capitale de la Grèce ?",
                listOf("Athènes", "Thessalonique", "Patras", "Heraklion"),
                "Athènes"
            ),
            Question(
                "Quelle est la capitale de la Hongrie ?",
                listOf("Budapest", "Debrecen", "Szeged", "Miskolc"),
                "Budapest"
            ),
            Question(
                "Quelle est la capitale de la Pologne ?",
                listOf("Varsovie", "Cracovie", "Wrocław", "Poznań"),
                "Varsovie"
            ),
            Question(
                "Quelle est la capitale de la Tchéquie ?",
                listOf("Prague", "Brno", "Ostrava", "Pilsen"),
                "Prague"
            ),
            Question(
                "Quelle est la capitale de la Roumanie ?",
                listOf("Bucarest", "Cluj-Napoca", "Timișoara", "Iași"),
                "Bucarest"
            ),
            Question(
                "Quelle est la capitale de la Bulgarie ?",
                listOf("Sofia", "Plovdiv", "Varna", "Burgas"),
                "Sofia"
            ),
            Question(
                "Quelle est la capitale de la Croatie ?",
                listOf("Zagreb", "Split", "Rijeka", "Osijek"),
                "Zagreb"
            )
        )
    }

    fun getAfricanQuestions(): List<Question> {
        return listOf(
            Question(
                "Quelle est la capitale du Nigéria ?",
                listOf("Lagos", "Abuja", "Accra", "Nairobi"),
                "Abuja"
            ),
            Question(
                "Quelle est la capitale du Kenya ?",
                listOf("Nairobi", "Kampala", "Dar es Salaam", "Addis-Abeba"),
                "Nairobi"
            ),
            Question(
                "Quelle est la capitale de l'Égypte ?",
                listOf("Le Caire", "Alexandrie", "Gizeh", "Luxor"),
                "Le Caire"
            ),
            Question(
                "Quelle est la capitale de l'Afrique du Sud ?",
                listOf("Pretoria", "Le Cap", "Johannesburg", "Durban"),
                "Pretoria"
            ),
            Question(
                "Quelle est la capitale du Maroc ?",
                listOf("Rabat", "Casablanca", "Marrakech", "Fès"),
                "Rabat"
            ),
            Question(
                "Quelle est la capitale du Ghana ?",
                listOf("Accra", "Kumasi", "Tamale", "Takoradi"),
                "Accra"
            ),
            Question(
                "Quelle est la capitale de l'Algérie ?",
                listOf("Alger", "Oran", "Constantine", "Annaba"),
                "Alger"
            ),
            Question(
                "Quelle est la capitale de la Tunisie ?",
                listOf("Tunis", "Sfax", "Sousse", "Bizerte"),
                "Tunis"
            ),
            Question(
                "Quelle est la capitale du Sénégal ?",
                listOf("Dakar", "Saint-Louis", "Touba", "Thiès"),
                "Dakar"
            ),
            Question(
                "Quelle est la capitale de l'Angola ?",
                listOf("Luanda", "Lobito", "Benguela", "Huambo"),
                "Luanda"
            ),
            Question(
                "Quelle est la capitale de l'Éthiopie ?",
                listOf("Addis-Abeba", "Mek'ele", "Gondar", "Awassa"),
                "Addis-Abeba"
            ),
            Question(
                "Quelle est la capitale de la Côte d'Ivoire ?",
                listOf("Yamoussoukro", "Abidjan", "Bouaké", "Daloa"),
                "Yamoussoukro"
            ),
            Question(
                "Quelle est la capitale du Cameroun ?",
                listOf("Yaoundé", "Douala", "Garoua", "Bamenda"),
                "Yaoundé"
            ),
            Question(
                "Quelle est la capitale de l'Ouganda ?",
                listOf("Kampala", "Entebbe", "Mbarara", "Gulu"),
                "Kampala"
            ),
            Question(
                "Quelle est la capitale du Zimbabwe ?",
                listOf("Harare", "Bulawayo", "Mutare", "Gweru"),
                "Harare"
            ),
            Question(
                "Quelle est la capitale du Mozambique ?",
                listOf("Maputo", "Matola", "Beira", "Nampula"),
                "Maputo"
            ),
            Question(
                "Quelle est la capitale du Soudan ?",
                listOf("Khartoum", "Omdourman", "Port-Soudan", "Kassala"),
                "Khartoum"
            ),
            Question(
                "Quelle est la capitale de la Libye ?",
                listOf("Tripoli", "Benghazi", "Misrata", "Sabha"),
                "Tripoli"
            ),
            Question(
                "Quelle est la capitale de la Zambie ?",
                listOf("Lusaka", "Kitwe", "Ndola", "Kabwe"),
                "Lusaka"
            )
        )
    }

    fun getAsianQuestions(): List<Question> {
        return listOf(
            Question(
                "Quelle est la capitale du Japon ?",
                listOf("Tokyo", "Pékin", "Séoul", "Bangkok"),
                "Tokyo"
            ),
            Question(
                "Quelle est la capitale de la Chine ?",
                listOf("Shanghai", "Pékin", "Hong Kong", "Taipei"),
                "Pékin"
            ),
            Question(
                "Quelle est la capitale de l'Inde ?",
                listOf("New Delhi", "Mumbai", "Bangalore", "Kolkata"),
                "New Delhi"
            ),
            Question(
                "Quelle est la capitale de la Corée du Sud ?",
                listOf("Séoul", "Busan", "Incheon", "Daegu"),
                "Séoul"
            ),
            Question(
                "Quelle est la capitale de la Thaïlande ?",
                listOf("Bangkok", "Phuket", "Chiang Mai", "Pattaya"),
                "Bangkok"
            ),
            Question(
                "Quelle est la capitale de l'Indonésie ?",
                listOf("Jakarta", "Surabaya", "Bandung", "Medan"),
                "Jakarta"
            ),
            Question(
                "Quelle est la capitale de la Malaisie ?",
                listOf("Kuala Lumpur", "George Town", "Johor Bahru", "Ipoh"),
                "Kuala Lumpur"
            ),
            Question(
                "Quelle est la capitale du Vietnam ?",
                listOf("Hanoï", "Ho Chi Minh Ville", "Da Nang", "Huế"),
                "Hanoï"
            ),
            Question(
                "Quelle est la capitale des Philippines ?",
                listOf("Manille", "Cebu", "Davao", "Quezon City"),
                "Manille"
            ),
            Question(
                "Quelle est la capitale de l'Arabie Saoudite ?",
                listOf("Riyad", "Djeddah", "Médine", "La Mecque"),
                "Riyad"
            ),
            Question(
                "Quelle est la capitale de l'Irak ?",
                listOf("Bagdad", "Bassorah", "Mossoul", "Erbil"),
                "Bagdad"
            ),
            Question(
                "Quelle est la capitale de l'Iran ?",
                listOf("Téhéran", "Ispahan", "Mashhad", "Shiraz"),
                "Téhéran"
            ),
            Question(
                "Quelle est la capitale du Pakistan ?",
                listOf("Islamabad", "Karachi", "Lahore", "Rawalpindi"),
                "Islamabad"
            ),
            Question(
                "Quelle est la capitale de l'Afghanistan ?",
                listOf("Kaboul", "Kandahar", "Herat", "Mazar-i-Sharif"),
                "Kaboul"
            ),
            Question(
                "Quelle est la capitale du Népal ?",
                listOf("Katmandou", "Pokhara", "Lalitpur", "Biratnagar"),
                "Katmandou"
            ),
            Question(
                "Quelle est la capitale du Bangladesh ?",
                listOf("Dacca", "Chittagong", "Khulna", "Rajshahi"),
                "Dacca"
            ),
            Question(
                "Quelle est la capitale de la Birmanie (Myanmar) ?",
                listOf("Naypyidaw", "Yangon", "Mandalay", "Bago"),
                "Naypyidaw"
            ),
            Question(
                "Quelle est la capitale du Sri Lanka ?",
                listOf("Sri Jayawardenapura", "Colombo", "Kandy", "Galle"),
                "Sri Jayawardenapura"
            ),
            Question(
                "Quelle est la capitale de la Jordanie ?",
                listOf("Amman", "Zarqa", "Irbid", "Aqaba"),
                "Amman"
            ),
            Question(
                "Quelle est la capitale du Liban ?",
                listOf("Beyrouth", "Tripoli", "Sidon", "Tyr"),
                "Beyrouth"
            )
        )
    }
}
