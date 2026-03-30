package prog2.vista;

import prog2.model.Allotjament;
import prog2.model.Camping;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author Yucheng Guo i Aleix Gutiérrez
 *
 * VistaCamping és una classe que crea el menú principal i un objecte de la classe Camping amb la
 * finalitat que l'usuari pugui realitzar determinades accions per consultar o modificar la informació
 * d'aquest càmping. També es pot guardar el càmping actual y carregar la seva informació en una altra sessió.
 */
public class VistaCamping {
    /**
     * Atributs de la classe VistaCamping
     */
    private Camping camping;

    //Declaramos las opciones del menú:
    static private enum OpcionesMenuPrincipal {MENU_PRINCIPAL_OPCIO1, MENU_PRINCIPAL_OPCIO2, MENU_PRINCIPAL_OPCIO3,
        MENU_PRINCIPAL_OPCIO4, MENU_PRINCIPAL_OPCIO5, MENU_PRINCIPAL_OPCIO6, MENU_PRINCIPAL_OPCIO7, MENU_PRINCIPAL_OPCIO8,
        MENU_PRINCIPAL_OPCIO9, MENU_PRINCIPAL_OPCIO10, MENU_PRINCIPAL_OPCIO11, MENU_PRINCIPAL_OPCIO12, MENU_PRINCIPAL_SORTIR};

    //Declaramos descripciones de las opciones del menú principal:
    static private String[] descMenuPrincipal = {"Llistar la informació de tots els allotjaments", "Llistar la informació dels allotjaments operatius",
    "Llistar la informació dels allotjaments no operatius", "Llistar la informació dels accessos oberts", "Llistar la informació del accessos tancats",
    "Llistar la informació de les tasques de manteniment actives", "Afegir una tasca de manteniment", "Completar una tasca de manteniment",
    "Calcular i mostrar el número total d’accessos que NO proporcionen accessibilitat amb vehicle", "Calcular i mostrar el número total de metres dels accessos de terra",
    "Guardar càmping", "Recuperar càmping", "Sortir de l'aplicació"};

    /**
     * Constructor de la classe VistaCamping
     * @param nom del càmping
     */
    public VistaCamping(String nom){
        this.camping = new Camping(nom);
        camping.inicialitzaDadesCamping();
    }

    /**
     * Es demanen a l'usuari les dades necessàries per afegir una nova tasca de manteniment
     *
     * @param sc (Scanner)
     * @throws ExcepcioCamping si no es pot finalitzar el procés
     */
    public void afegirTascaManteniment(Scanner sc) throws ExcepcioCamping{
        boolean datoCorrecto = false;
        boolean continuar = false;
        int numId = -1;
        int diesTasca = -1;
        String nom = null;
        String opcion = null;
        String tipusTasca = null;
        String data;
        Allotjament allotjament = null;
        //Nos aseguramos de que los datos sean correctos
        //Identificador:
        do{
            try{
                System.out.println("Identificador (enter positiu): ");
                numId = sc.nextInt();
                if(numId > 0){datoCorrecto = true;}
            }catch(InputMismatchException e){
                System.out.println("Valor incorrecte");
                sc.nextLine();
            }
        } while(!datoCorrecto);

        datoCorrecto = false;
        sc.nextLine();
        //Nombre del alojamiento:
        do{
            try{
                System.out.println("Nom de l'allotjament: ");
                nom = sc.nextLine();
                allotjament = camping.getAllotjamentByName(nom);
                continuar = true;
            } catch(Exception e){
                System.out.println(e.getMessage() + ". Vols intentar de nou? (s/n): ");
                opcion = sc.nextLine().toLowerCase();
                if(!opcion.equals("s")){
                    throw new ExcepcioCamping("No s'ha pogut completar el procés");
                }
            }
        }while(!continuar);

        //Tipo de tarea:
        System.out.println("Tipus de tasca (Neteja, Reparacio, RevisioTecnica, Desinfeccio): ");
        tipusTasca = sc.nextLine();

        //Fecha:
        System.out.println("Data (per exemple: 2026-03-29): ");
        data = sc.nextLine();

        //Dias de duración de la tarea:
        do{
            try{
                System.out.println("Dies (enter positiu): ");
                diesTasca = sc.nextInt();
                if(diesTasca > 0){datoCorrecto = true;}
            }catch(InputMismatchException e){
                System.out.println("Valor incorrecte");
                sc.nextLine();
            }
        } while(!datoCorrecto);
        sc.nextLine();
        //Añadimos la tarea:
        camping.afegirTascaManteniment(numId, tipusTasca, allotjament.getId(), data, diesTasca);
    }

    /**
     * Mostra per pantalla les tasques de manteniment actives i demana a l'usuari l'identificador
     * de la tasca que vol completar.
     *
     * @param sc
     */
    public void completarTascaMantenimentVista(Scanner sc) throws ExcepcioCamping{
        int numId = -1;
        boolean datoCorrecto = false;

        //Mostramos por pantalla las tareas:
        System.out.println(camping.llistarTasquesManteniment());

        //Pedimos al usuario el número identificador de la tarea:
        do{
            try{
                System.out.println("Identificador (enter positiu): ");
                numId = sc.nextInt();
                if(numId > 0){datoCorrecto = true;}
            }catch(InputMismatchException e){
                System.out.println("Valor incorrecte");
                sc.nextLine();
            }
        } while(!datoCorrecto);

        camping.completarTascaManteniment(numId);
    }

    /**
     * Carrega la informació guardada en una altra sessió
     * @return Camping
     */
    public Camping load(String camino) throws ExcepcioCamping{
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(camino));
            Camping camping = (Camping) ois.readObject();
            ois.close();
            return camping;
        } catch(Exception e){
            throw new ExcepcioCamping ("Error carregant el ficher");
        }
    }

    /**
     * Gestiona el menú d'opcions per consultar o modificar informació del càmping
     */
    public void gestioCamping(){
        Scanner sc = new Scanner(System.in);

        //Creamos el objeto de la clase Menu
        Menu<OpcionesMenuPrincipal> menu = new Menu<>("Menu Principal", OpcionesMenuPrincipal.values());

        //Asignamos las descripciones correspondientes a cada opción
        menu.setDescripcions(descMenuPrincipal);

        //Obtenemos una opción desde el menú principal y realizamos la acción indicada
        OpcionesMenuPrincipal opcion = null;
        do{
            //Mostramos las opciones del menú
            menu.mostrarMenu();

            //Pedimos la opción:
            opcion = menu.getOpcio(sc);

            //Actuamos según la opción escogida:
            switch(opcion){
                case MENU_PRINCIPAL_OPCIO1: try{
                    System.out.println(camping.llistarAllotjaments("Tots"));
                } catch (Exception e){
                    System.err.println(e.getMessage());
                }
                break;
                case MENU_PRINCIPAL_OPCIO2: try{
                    System.out.println(camping.llistarAllotjaments("Operatiu"));
                } catch (Exception e){
                    System.err.println(e.getMessage());
                }
                break;
                case MENU_PRINCIPAL_OPCIO3: try{
                    System.out.println(camping.llistarAllotjaments("No operatiu"));
                } catch (Exception e){
                    System.err.println(e.getMessage());
                }
                break;
                case MENU_PRINCIPAL_OPCIO4: try{
                    System.out.println(camping.llistarAccessos("Obert"));
                }
                catch(Exception e){
                    System.err.println(e.getMessage());
                }
                break;
                case MENU_PRINCIPAL_OPCIO5: try{
                    System.out.println(camping.llistarAccessos("Tancat"));
                }
                catch(Exception e){
                    System.err.println(e.getMessage());
                }
                break;
                case MENU_PRINCIPAL_OPCIO6: try{
                    System.out.println(camping.llistarTasquesManteniment());
                }
                catch(Exception e){
                    System.err.println(e.getMessage());
                }
                break;
                case MENU_PRINCIPAL_OPCIO7: try{
                    afegirTascaManteniment(sc);
                }catch(Exception e){
                    System.err.println(e.getMessage());
                } break;
                case MENU_PRINCIPAL_OPCIO8: try{
                    completarTascaMantenimentVista(sc);
                }catch(Exception e){
                    System.err.println(e.getMessage());
                } break;
                case MENU_PRINCIPAL_OPCIO9: System.out.println(camping.calculaAccessosNoAccessibles()); break;
                case MENU_PRINCIPAL_OPCIO10: System.out.println(camping.calculaMetresTerra() + "m"); break;
                case MENU_PRINCIPAL_OPCIO11: try{
                    System.out.println("Ruta del fitxer: ");
                    String ruta = sc.nextLine();
                    camping.save(ruta);
                }catch(Exception e){
                    System.out.println(e.getMessage());
                }break;
                case MENU_PRINCIPAL_OPCIO12: try{
                    System.out.println("Ruta del fitxer: ");
                    String ruta = sc.nextLine();
                    this.camping = load(ruta);
                }catch(Exception e){
                    System.out.println(e.getMessage());
                }break;
                case MENU_PRINCIPAL_SORTIR: System.out.println("Fins la propera"); break;
            }

        }while(opcion!=OpcionesMenuPrincipal.MENU_PRINCIPAL_SORTIR);

    }
}
