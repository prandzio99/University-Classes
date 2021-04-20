import java.util.*;

class Tree { 
    Node root;              //korzeń drzewa

    Tree() {root = null;}   //konstruktor drzewa
    
    class Node { 
        int key;            //klucz
        Node left, right;   //wskaźniki na dzieci
        int count;          //licznik wystąpień
  
        public Node(int val) {      //konstruktor węzła
            key = val; 
            left = right = null;
            count = 1;
        } 
    } 
 
    void insert(int key) {root = insertRec(root, key);}

    void insert(List<Integer> key) {for(int i = 0; i < key.size(); i++) root = insertRec(root, key.get(i));}
      
    Node insertRec(Node root, int key) {
        if (root == null) {root = new Node(key); return root;}              //jeśli węzeł jest pusty to wstawia nowy
        if (key == root.key) {root.count++; return root;}                   //jeśli węzeł ma klucz równy wstawianemu to zwiększa licznik o jeden
        else if (key < root.key) root.left = insertRec(root.left, key);     //jeśli wstawiany klucz jest mniejszy niż klucz węzła, to rekurencyjnie wywołuje wstawianie na lewym dziecku
        else root.right = insertRec(root.right, key);                       //jeśli wstawiany klucz jest większy niż klucz węzła, to rekurencyjnie wywołuje wstawianie na prawym dziecku
        return root;                                                        //zwraca niezmieniony korzeń drzewa
    } 
  
    void inorder() {inorderRec(root);} 
  
    void inorderRec(Node root) { 
        if (root != null) {                                         //jeśli korzeń nie jest pusty
            inorderRec(root.left);                                  //wywołuje wypisywanie lewego dziecka
            System.out.print(root.key+"("+root.count+")\t");        //wypisuje wartość klucza z powtórzeniami
            inorderRec(root.right);                                 //wywołuje wypisywanie prawego dziecka
        } 
    }

    void deleteKey(int key) {root = deleteRec(root, key);}
    void deleteKey(List<Integer> key) {for(int i = 0; i < key.size(); i++) root = deleteRec(root, key.get(i));}
  
    Node deleteRec(Node root, int key) { 
        if (root == null)  return root;                                     //jeśli korzeń jest pusty zwraca korzeń
        if (key < root.key) root.left = deleteRec(root.left, key);          //jeśli klucz jest mniejszy niż klucz węzła to wywołuje rekurencyjnie usuwanie na lewym dziecku
        else if (key > root.key) root.right = deleteRec(root.right, key);   //jeśli klucz jest większy niż klucz węzła to wywołuje rekurencyjnie usuwanie na prawym dziecku
        else {                                                              //jeśli klucze są równe
            if (root.count > 1) {(root.count)--; return root;}              //jeśli licznik jest większy niż jeden, zmniejsza go o 1 i zwraca korzeń
            if (root.left == null) return root.right;                       //jeśli jest równy jeden, sprawdza czy lewe dziecko jest puste, zwraca prawe dziecko
            else if (root.right == null) return root.left;                  //jeśli nie, sprawdza prawe dziecko jeśli puste, zwraca lewe
            root.key = minValue(root.right);                                //jeśli oba są nie puste, na klucz ustawia najmniejszą wartość z prawego poddrzewa
            root.right = deleteRec(root.right, root.key);                   //rekurencyjnie wywołuje usuwanie na prawym poddrzewie najmniejszej wartości
        } 
        return root;                                                        //zwraca korzeń
    } 
  
    int minValue(Node root) { 
        int minv = root.key;            //minimalna wartość = klucz korzenia
        while (root.left != null) {     //dopóki lewy korzeń nie != null
            minv = root.left.key;       //minimalna wartość = klucz lewego dziecka
            root = root.left;           //korzeń = lewe dziecko
        } 
        return minv;                    //zwraca minimalną wartość drzewa
    }

    static boolean search(Node root, int key) { 
            if (root==null) return false;                       //jeśli korzeń równy null zwraca false
            if (root.key==key) return true;                     //jeśli klucz równy szukanemu zwraca true
            if (root.key > key) return search(root.left, key);  //jeśli klucz większy od szukanego rekurecyjne wywołanie na lewym poddrzewie
            else return search(root.right, key);                //jeśli klucz mniejszy od szukanego rekurencyjne wywołanie na prawym poddrzewie
    }
  
     public static void main(String[] args) { 
        Tree tree = new Tree();

        tree.insert(Arrays.asList(17, 18, 11, 6, 30, 18, 19, 18, 17, 23, 18, 18, 26, 17));
  
        System.out.println("Pierwszy wydruk: ");
        tree.inorder();
        
        tree.deleteKey(18);
        
        System.out.println();
        System.out.println("Drugi wydruk: ");
        tree.inorder();
        
        tree.deleteKey(Arrays.asList(11, 23, 18, 18, 17));
        
        System.out.println();
        System.out.println("Trzeci wydruk: ");
        tree.inorder();

        System.out.println();
        if(search(tree.root, 6)) System.out.println("W drzewie znajduje się klucz 6.");
        if(!(search(tree.root, 16))) System.out.println("W drzewie nie znajduje się klucz 16.");
    }
}