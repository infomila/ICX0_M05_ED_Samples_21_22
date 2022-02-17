
package refactoring;

/**
 *
 * @author Usuari
 */
public enum MovieType {
    REGULAR(MoviePriceTypeRegular.class) ,
    NEW_RELEASE(MoviePriceTypeNewRelease.class) , 
    CHILDRENS(MoviePriceTypeChildren.class)  ;
    
    Class type;
    MovieType(Class type) {
        this.type = type;
    }
    
    public Class getType(){
        return this.type;
    }
}
