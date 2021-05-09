package com.example.projetds

import android.content.ContentValues
import android.content.Context

class DataManager(val context: Context) {


    val helper = myDBHelper(context)

    fun fillData(){
        val db = helper.readableDatabase
        val cursor = db.query(DBContract.Question.TABLE_NAME, null, null, null, null, null, null)
        if (cursor.count == 0){
            //Intent Chapter Data
            add("Chaque activité a une entrée dans le fichier ?", "Intent", "AndroidManifest.xml", "Gradle", "MainActivity","AndroidManifest.xml")
            add("C'est quoi un Intent ?", "Intent", "Un type d'adapter", "Un objet qui sert à stocker les données", "Un pont entre les activités","Un pont entre les activités")
            add("Comment déclarer un Intent ?", "Intent", "Intent(this,ActivityName::class.java)", "Intent(this,ActivityName)", "Intent(this,nameSpace::ActivityName)","Intent(this,ActivityName::class.java)")
            add("La deuxième activité peut répondre à l'intent?", "Intent", "Non", "Oui, mais elle ne peut pas envoyer des données", "Oui,elle ne peut pas envoyer des données","Oui,elle ne peut pas envoyer des données")
            add("On trasmet les données dans l'intent avec la methode?", "Intent", "intent.sendExtra(\"name\",value)", "intent.putExtra(\"name\",value)", "l'intent ne transmet pas les données","intent.putExtra(\"name\",value)")
            add("Si l’ activité appelante veut attendre le résultat de l'activité appelée, on utilise ?", "Intent", "startActivity", "startActivityForResult", "startActivityForAnswer","startActivityForResult")
            add("Comment la seconde activité connait l'activité appelante ?", "Intent", "numero d'identification unique", "le nom de l'activity", "declaration dans AndroidManifest","identification unique")
            add("Pour renvyer des données à l'activité appelante, on appelle la fonction?", "Intent", "startResult", "startActivityForResult", "setResult","setResult")
            add("le nom de la fonction dans la premiere actiVity pour récuperer les donnéEs?", "Intent", "onActivityResult", "onResultIntent", "onIntentAnswer","onActivityResult")
            add("C'est quoi un Intent Implicite est un intent?", "Intent", "lance une autre application sans la nommer", "se lance implicitement par defaut sans le déclarer", "relance la meme activity dans l'application","lance une autre application sans la nommer")
            add("Pourquoi on utilise les Bundles avec l'Intent?", "Intent", "on peut envoyer des données volumieux ou des objets avec bundles", "les Bundles sont mieux en terme de rapidité", "les Bundles rendre les données plus léger en terme de mémoire","on peut envoyer des données volumieux ou des objets avec bundles")
            add("Pour envoyer un objet dans le bundle il faut ?", "Intent", "l'objet doit etre serialisable ou parcelable", "l'objet doit definir les getters et les setters", "rien des deux autre réponses","l'objet doit etre serialisable ou parcelable")
            add("Pour passer des paramétres dans le bundle on utilise ?", "Intent", "sendParcelableObject", "putObject", "putParcelable","putParcelable")
            add("Pour recuperer le bundle dans l'activité 2 on utilise?", "Intent", "myIntent.getMyBundle", "myIntent.extras", "myIntent.resultBundle","myIntent.extras")
            add("Pour récuperer un objet Person parcelable envoyé depuis le bundle, on utilise?", "Intent", "myBundle.getParcelable<Person>('p1')", "myBundle.getParcelable('p1',Person)", "myIntent.getPerson('p1')","myBundle.getParcelable<Person>('p1')")

            //Stoacke and SQLite Data
            add("Quelle type de fichiers utilisés pour manipulerdes petits data", "Stockage et Sqlite", "SharedPreferences", "Bundles", "Bases de données SQLite","SharedPreferences")
            add("On utilise un editor pour SharedPreferences pour ?", "Stockage et Sqlite", "put, remove", "get", "get, put, remove","put, remove")
            add("Comment récuperer les preferences spécifiques à l'activité?", "Stockage et Sqlite", "getSharedPreferences('activity1')", "getSharedPreferences()", "getPreferences()","getPreferences()")
            add("Le stockage interne est toujours accessible par ?", "Stockage et Sqlite", "que votre application", "toutes les applications", "méme aprés la desinstallation de l'application","que votre application")
            add("Le stockage externe est accessible?", "Stockage et Sqlite", "que votre application", "toujours accessible", "apres desinstallation de l'application","apres desinstallation de l'application")
            add("Pour créer un FileInputStream, On utilise ?", "Stockage et Sqlite", "openFileInput()", "openFile()", "SendStream()","openFileInput()")
            add("GetSharedPreferences(),Accède aux préférences au niveau de:", "Stockage et Sqlite", "l'activité", "l'application", "le contexte","l'application")
            add("Pour lire/écrire dans le stockage externe du périphérique,il faut demander l'autorisation?", "Stockage et Sqlite", "Grradle", "AndroidManifest.xml", "ActivityMain","AndroidManifest.xml")
            add("que fait la fonction getExternalFilesDir ('name')", "Stockage et Sqlite", "renvoie le répertoire externe \"privé\" sous \"name\"", "renvoie le répertoire externe \"public\" sous name", "renvoie le répertoire externe \"name\"","renvoie le répertoire externe \"privé\" sous \"name\"")
            add("SQLite est une bibliothèque?", "Stockage et Sqlite", "open source écrite en langage C", "open source écrite en Java", "moteur lite pour MySQL","open source écrite en langage C")
            add("Les fichiers SharedPreferences sont utilisés pour manipuler:", "Stockage et Sqlite", "petits data", "grands data", "Les deux","petits data")
            add("Quelle le type de donnée qui n'existe pas dans SQLite?", "Stockage et Sqlite", "INTEGER", "NUMERIC", "VARCHAR","VARCHAR")
            add("La fonction qui qui n'est pas utilisée en SQLiteOpenHelper", "Stockage et Sqlite", "onUpgrade()", "onCreate()", "onBinding()","onBinding()")
            add("Pour inserer dans la base de donnée on utilise :", "Stockage et Sqlite", "insert()", "putInto()", "insertInto()","insert()")
            add("Pour regarder une ligne dans le curseur on utilise", "Stockage et Sqlite", "Next()", "moveToNext()", "NextElement()","moveToNext()")

            //Fragments
            add("La premiere methode pour lancer un Fragment?", "Fragments", "OnDestroy()", "OnCreate()", "OnAttach()","OnAttach()")
            add("La derniere methode pour un Fragment?", "Fragments", "OnDetach()", "OnCreate()", "OnDestroy()","OnDetach()")
            add("Comment les Fragment Communiquent ?", "Fragments", "Directement", "avec Interface", "Bundle","avec Interface")
            add("Les Fragment Prévus dans le Layout s'ajoutent?", "Fragments", "Statiquement", "Dynamiquement", "Automatiquement","Statiquement")
            add("Definir les Fragment Dynamiquement, On utilise?", "Fragments", "FragmentDynamique", "FragmentManager", "FragmentSetter","FragmentManager")
            add("Un Fragment doit hériter de la classe ?", "Fragments", "Fragment", "AndroidFragment", "JavaFragment","Fragment")
            add("Add/delete de fragments se fait à l’aide?", "Fragments", "methode de la classe Fragment", "interface de l'activity", "des transactions","des transactions")
            add("Pour remplacer un Fragment ?", "Fragments", "replace()", "remove() puis add()", "update()","replace()")
            add("Pour lier le layout au Fragment on Redéfinit?", "Fragments", "onCreate()", "onCreateView()", "OnFragmentCreate()","onCreateView()")
            add("Pour efectuer une transaction ?", "Fragments", "trans.applicate()", "trans.done()", "trans.commit()","trans.commit()")
            add("Pour ajouter un Fragment ?", "Fragments", "R.id.frag_liste.add(frag1)", "trans.add(R.id.frag_liste, frag1)", "trans.add(frag1)","trans.add(R.id.frag_liste, frag1)")
            add("Un fragment doit avoir un identifiant ?", "Fragments", "Non", "Oui", "pour les fragments de la meme classe","Oui")
            add("Les fragments se comportent comme?", "Fragments", "Threads", "Bundles", "RecyclerView","Threads")
            add("Les fragments se comportent comme une activity ?", "Fragments", "OUi", "Non", "comme un Thread","comme un Thread")
            add("On peut mettre un Fragment dans un autre ?", "Fragments", "Oui", "Non", "Oui,avec une dimension inferieure","Nons")







        }
    }
    fun add(question: String, chapitre: String, choix1: String, choix2: String, choix3: String, choix_correct: String) {
        val dataBase = helper.writableDatabase
        val values = ContentValues()
        values.put(DBContract.Question.QUESTION, question)
        values.put(DBContract.Question.CHAPITRE, chapitre)
        values.put(DBContract.Question.CHOIX1, choix1)
        values.put(DBContract.Question.CHOIX2, choix2)
        values.put(DBContract.Question.CHOIX3, choix3)
        values.put(DBContract.Question.CHOIX_CORRECT, choix_correct)

        val rowAffected = dataBase?.insert(DBContract.Question.TABLE_NAME, null, values)
    }

    /*
    fun delete(nom: String) {
        val dataBase = helper.writableDatabase
        val selection = "${DBContract.Question.NOM} = ?"
        val selectionArgs = arrayOf("$nom")
        val deleteRows = dataBase.delete(DBContract.Question.TABLE_NAME, selection, selectionArgs)
    }
    */
    fun getAllItems(): ArrayList<Question> {
        val result = ArrayList<Question>()
        val dataBase = helper.readableDatabase

        val cursor = dataBase?.query(DBContract.Question.TABLE_NAME, null, null, null, null, null, null)
        while (cursor?.moveToNext()!!) {
            //val id = cursor.getInt(cursor.getColumnIndex(BaseColumns._ID))
            val question = cursor.getString(cursor.getColumnIndex(DBContract.Question.QUESTION))
            val chapitre = cursor.getString(cursor.getColumnIndex(DBContract.Question.CHAPITRE))
            val choix1 = cursor.getString(cursor.getColumnIndex(DBContract.Question.CHOIX1))
            val choix2 = cursor.getString(cursor.getColumnIndex(DBContract.Question.CHOIX2))
            val choix3 = cursor.getString(cursor.getColumnIndex(DBContract.Question.CHOIX3))
            val choix_correct = cursor.getString(cursor.getColumnIndex(DBContract.Question.CHOIX_CORRECT))
            result.add(Question(question, chapitre, choix1, choix2, choix3, choix_correct))
        }
        return result
    }

    fun getTenRandom(chapitre: String):ArrayList<Question>{
        val selection = "${DBContract.Question.CHAPITRE} = ?"
        val selectionArgs = arrayOf(chapitre)
        val result = ArrayList<Question>()
        val dataBase = helper.readableDatabase
        val cursor = dataBase?.query(DBContract.Question.TABLE_NAME, null, selection, selectionArgs, null, null, "RANDOM() limit 10")
        while (cursor?.moveToNext()!!) {
            //val id = cursor.getInt(cursor.getColumnIndex(BaseColumns._ID))
            val question = cursor.getString(cursor.getColumnIndex(DBContract.Question.QUESTION))
            val choix1 = cursor.getString(cursor.getColumnIndex(DBContract.Question.CHOIX1))
            val choix2 = cursor.getString(cursor.getColumnIndex(DBContract.Question.CHOIX2))
            val choix3 = cursor.getString(cursor.getColumnIndex(DBContract.Question.CHOIX3))
            val choix_correct = cursor.getString(cursor.getColumnIndex(DBContract.Question.CHOIX_CORRECT))
            result.add(Question(question, chapitre, choix1, choix2, choix3, choix_correct))
        }
        return result

    }
    /*
    fun update(nom: String, prenom: String, imagePath : String) {
        val dataBase = helper.writableDatabase
        val selection = "${DBContract.Question.NOM} = ?"
        val selectionArgs = arrayOf("$NOM")
        val values = ContentValues()
        values.put(DBContract.Question.NOM, nom)
        values.put(DBContract.Question.PRENOM, prenom)
        values.put(DBContract.Question.IMAGEPATH, imagePath)
        val nbRowsUpdated = dataBase.update(DBContract.Question.TABLE_NAME, values, selection, selectionArgs)
    }
*/
    fun close() {
        helper.close();
    }
}