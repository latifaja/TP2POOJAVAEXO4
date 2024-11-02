import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MetierProduitImpl metier = new MetierProduitImpl();
        boolean continuer = true;

        while (continuer) {
            System.out.println("\nMenu :");
            System.out.println("1. Afficher la liste des produits.");
            System.out.println("2. Rechercher des produits par mot clé.");
            System.out.println("3. Ajouter un nouveau produit dans la liste.");
            System.out.println("4. Récupérer et afficher un produit par ID.");
            System.out.println("5. Supprimer un produit par id.");
            System.out.println("6. Quitter ce programme.");
            System.out.print("Choisissez une option : ");
            int choix = scanner.nextInt();
            scanner.nextLine(); // Consommer le saut de ligne

            switch (choix) {
                case 1:
                    List<Produit> produits = metier.getAll();
                    if (produits.isEmpty()) {
                        System.out.println("La liste des produits est vide.");
                    } else {
                        produits.forEach(System.out::println);
                    }
                    break;

                case 2:
                    System.out.print("Entrez le mot clé : ");
                    String motCle = scanner.nextLine();
                    List<Produit> resultats = metier.findByNom(motCle);
                    if (resultats.isEmpty()) {
                        System.out.println("Aucun produit trouvé avec ce mot clé.");
                    } else {
                        resultats.forEach(System.out::println);
                    }
                    break;

                case 3:
                    System.out.print("Entrez l'ID : ");
                    long id = scanner.nextLong();
                    scanner.nextLine();
                    System.out.print("Entrez le nom : ");
                    String nom = scanner.nextLine();
                    System.out.print("Entrez la marque : ");
                    String marque = scanner.nextLine();
                    System.out.print("Entrez le prix : ");
                    double prix = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Entrez la description : ");
                    String description = scanner.nextLine();
                    System.out.print("Entrez le nombre en stock : ");
                    int nombreEnStock = scanner.nextInt();
                    scanner.nextLine();

                    Produit produit = new Produit(id, nom, marque, prix, description, nombreEnStock);
                    metier.add(produit);
                    System.out.println("Produit ajouté avec succès !");
                    break;

                case 4:
                    System.out.print("Entrez l'ID du produit : ");
                    long idRecherche = scanner.nextLong();
                    scanner.nextLine();
                    Produit produitRecherche = metier.findById(idRecherche);
                    if (produitRecherche == null) {
                        System.out.println("Aucun produit trouvé avec cet ID.");
                    } else {
                        System.out.println(produitRecherche);
                    }
                    break;

                case 5:
                    System.out.print("Entrez l'ID du produit à supprimer : ");
                    long idSupprimer = scanner.nextLong();
                    scanner.nextLine();
                    metier.delete(idSupprimer);
                    System.out.println("Produit supprimé avec succès.");
                    break;

                case 6:
                    continuer = false;
                    System.out.println("Programme terminé.");
                    break;

                default:
                    System.out.println("Option non valide. Veuillez réessayer.");
                    break;
            }
        }

        scanner.close();
    }
}
