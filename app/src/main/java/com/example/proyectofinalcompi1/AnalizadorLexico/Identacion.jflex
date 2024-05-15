package com.example.proyectofinalcompi1.AnalizadorLexico;



%% //separador de area

%public
%unicode
%intwrap
%class Identador

%init{
    string = new StringBuffer();
    identation = "    ";
    identacionActual = 0;
%init}


LineTerminator = \r|\n|\r\n
WhiteSpace = {LineTerminator} | [ \t\f]

/* constants */
/* nothing here */


%{
    StringBuffer string;
    String identation;
    int identacionActual;

    public String getString(){
        return this.string.toString();
    }

    private String identar(int times){
   String codigo = "";
        for(int index = 0; index < times; index++){
            codigo += identation;
        }
        return codigo;
    }
%}

%%





    ("{"|"[")         {
                                    string.append(yytext());
                                    string.append("\n");
                                    identacionActual++;
                                    string.append(this.identar(identacionActual));
                                    return 1;
                                }
    ","            {
                                    string.append(yytext());
                                    string.append("\n");
                                    string.append(this.identar(identacionActual));
                                    return 1;
                                 }


    ("]"|"}")     {
                                    string.append("\n");
                                    if(identacionActual > 0){
                                        identacionActual--;
                                    }
                                    string.append(this.identar(identacionActual));
                                    string.append(yytext());
                                    string.append("\n");
                                    return 1;
                                }

    "},"            {
                                     string.append("\n");
                                     if(identacionActual > 0){
                                        identacionActual--;
                                     }
                                     string.append(this.identar(identacionActual));
                                     string.append(yytext());
                                     string.append("\n");
                                     string.append(this.identar(identacionActual));
                                     return 1;
                                 }


    [^]             { string.append(yytext().replace("\n", "")); }