export class SistemaAuth{
    static login(userToBeAuth, senha){
        if(SistemaAuth.isAuth(userToBeAuth)){
            return userToBeAuth.autenticar(senha);
        }
        return false;
    }

    static isAuth(userToBeAuth){
        return "autenticar" in userToBeAuth 
        && userToBeAuth.autenticar instanceof Function;
    }
}