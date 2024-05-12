
package AnalizadorLexico;

import AnalizadorSintactico.sym;

import java_cup.runtime.*;

%%
%public
%class analizadorLexico
%cup
%line
%column


L=[a-zA-Z_]
D=[0-9]+
special = [_\-\$]
hexDigit = [0-9a-fA-F]

espacio=[ | \t | \r | \n]

%{

  private Symbol symbol(int type) {
    return new Symbol(type, yyline+1, yycolumn+1);
  }

  private Symbol symbol(int type, Object value) {
    return new Symbol(type, yyline+1, yycolumn+1, value);
  }


    private void error(String message) {
      System.out.println("Error en linea line "+(yyline+1)+", columna "+(yycolumn+1)+" : "+message);
    }


%}




%%
//paralbras reservadas



\"title\" {return symbol(sym.TITLE, yytext()); }
\"description\" {return symbol(sym.DESCRIPTION, yytext()); }


\"keywords\" {return symbol(sym.KEYWORDS, yytext()); }
\"header\" {return symbol(sym.HEADER, yytext()); }


\"footer\" {return symbol(sym.FOOTER, yytext()); }
\"backgroundColor\" {return symbol(sym.BACKGROUND_COLOR, yytext()); }

\"fontFamily\" {return symbol(sym.FONT_FAMILY, yytext()); }
\"fontSize\" {return symbol(sym.FONT_SIZE, yytext()); }


\"data\" {return symbol(sym.DATA, yytext()); }
\"category\" {return symbol(sym.CATEGORY, yytext()); }

\"value\" {return symbol(sym.VALUE, yytext()); }
\"color\" {return symbol(sym.COLOR, yytext()); }



\"chart\" {return symbol(sym.CHART, yytext()); }



\"xAxisLabel\" {return symbol(sym.X_AXIS_LABEL, yytext()); }
\"yAxisLabel\" {return symbol(sym.Y_AXIS_LABEL, yytext()); }
\"legendPosition\" {return symbol(sym.LEGEND_POSITION, yytext()); }



\"x\" {return symbol(sym.X, yytext()); }

\"y\" {return symbol(sym.Y, yytext()); }




\"size\" {return symbol(sym.SIZE, yytext()); }

\"name\" {return symbol(sym.NAME, yytext()); }

\"points\" {return symbol(sym.POINTS, yytext()); }


\"lineStyle\" {return symbol(sym.LINE_STYLE, yytext()); }




\"label\" {return symbol(sym.LABEL, yytext()); }
\"#([0-9a-fA-F]{3}){1,2}\" { return symbol(sym.HEXADECIMAL, yytext()); }





\"icon\" {return symbol(sym.ICON, yytext()); }

\"link\" {return symbol(sym.LINK, yytext()); }


if {return symbol(sym.IF, yytext()); }
else {return symbol(sym.ELSE, yytext()); }

for {return symbol(sym.FOR, yytext()); }



while {return symbol(sym.WHILE, yytext()); }


do {return symbol(sym.DO, yytext()); }
true {return symbol(sym.TRUE, yytext()); }
false {return symbol(sym.FALSE, yytext()); }
asigancion



"*" {return symbol(sym.ASTERISCO, yytext()); }

"." {return symbol(sym.ASTERISCO, yytext()); }
"," {return symbol(sym.COMA, yytext()); }
";" {return symbol(sym.PUNTO_COMA, yytext()); }
":" {return symbol(sym.DOS_PUNTOS, yytext()); }
"(" {return symbol(sym.PARENTESIS_A, yytext()); }
")" {return symbol(sym.PARENTESIS_C, yytext()); }
"{" {return symbol(sym.LLAVE_A, yytext()); }
"}" {return symbol(sym.LLAVE_C, yytext()); }
"[" {return symbol(sym.CORCHETE_A, yytext()); }
"]" {return symbol(sym.CORCHETE_C, yytext()); }
"/" {return symbol(sym.BARRA, yytext()); }



//comparadores

"<=" {return symbol(sym.MENOR_IGUAL, yytext()); }

">=" { return symbol(sym.MAYOR_IGUAL, yytext()); }
"!>" { return symbol(sym.DIFERENTE, yytext()); }

"=" {return symbol(sym.IGUAL, yytext()); }
"==" {return symbol(sym.IGUAL_IGUAL, yytext()); }
"<" {return symbol(sym.MENOR_QUE, yytext()); }
">" {return symbol(sym.MAYOR_QUE, yytext()); }





"+" {return symbol(sym.MAS, yytext()); }
"-" {return symbol(sym.MENOS, yytext()); }








{espacio} {/*Ignore*/}









({special} | {L} | {D})({L}|{D}|{special})*"ID" { return symbol(sym.IDENTIFICADOR, yytext()); }






("(-"{D}+")")|{D}+ {return symbol(sym.CONSTANTE,  yytext()  );}

("-"?{D}+"."{D}+) | {D}+ {return symbol(sym.CONSTANTE,  yytext()  );}

"\"" {return symbol(sym.COMILLA, yytext()  );}

\"[^\"]+\" { return symbol(sym.CADENA, yytext().substring(1, yytext().length() - 1));}





[^]                              /*{ throw new RuntimeException("Illegal character \""+yytext()+
                                                              "\" at line "+yyline+", column "+yycolumn); }*/
			{error("Simbolo invalido <"+ yytext()+">");}
<<EOF>>                 { return symbol(sym.EOF); }

