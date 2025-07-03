package comum;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class conexaoMongo {
    private static MongoClient client;
    private static MongoDatabase database;
    
    public static MongoDatabase getDatabase() {
        if (database == null) {
            try {
                client = MongoClients.create("mongodb://localhost:27017");
                database = client.getDatabase("urna_eletronica");
                System.out.println("Conectado ao MongoDB!");
            } catch (Exception e) {
                System.err.println("Erro ao conectar: " + e.getMessage());
                throw e;
            }
        }
        return database;
    }
    
    public static void fecharConexao() {
        if (client != null) {
            client.close();
            database = null;
            System.out.println("Conexão fechada.");
        }
    }
}