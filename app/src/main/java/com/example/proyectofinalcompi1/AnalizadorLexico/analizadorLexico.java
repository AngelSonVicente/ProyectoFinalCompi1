// DO NOT EDIT
// Generated by JFlex 1.9.1 http://jflex.de/
// source: AnalizadorLexico.jflex


package com.example.proyectofinalcompi1.AnalizadorLexico;

import com.example.proyectofinalcompi1.AnalizadorSintactico.sym;

import java_cup.runtime.*;


@SuppressWarnings("fallthrough")
public class analizadorLexico implements java_cup.runtime.Scanner {

  /** This character denotes the end of file. */
  public static final int YYEOF = -1;

  /** Initial size of the lookahead buffer. */
  private static final int ZZ_BUFFERSIZE = 16384;

  // Lexical states.
  public static final int YYINITIAL = 0;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = {
     0, 0
  };

  /**
   * Top-level table for translating characters to character classes
   */
  private static final int [] ZZ_CMAP_TOP = zzUnpackcmap_top();

  private static final String ZZ_CMAP_TOP_PACKED_0 =
    "\1\0\u10ff\u0100";

  private static int [] zzUnpackcmap_top() {
    int [] result = new int[4352];
    int offset = 0;
    offset = zzUnpackcmap_top(ZZ_CMAP_TOP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackcmap_top(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /**
   * Second-level tables for translating characters to character classes
   */
  private static final int [] ZZ_CMAP_BLOCKS = zzUnpackcmap_blocks();

  private static final String ZZ_CMAP_BLOCKS_PACKED_0 =
    "\11\0\2\1\2\0\1\1\22\0\1\1\1\2\1\3"+
    "\1\4\1\5\3\0\1\6\1\7\1\10\1\11\1\12"+
    "\1\13\1\14\1\15\12\16\1\17\1\20\1\21\1\22"+
    "\1\23\2\0\1\24\1\25\1\26\1\27\1\25\1\30"+
    "\2\5\1\31\2\5\1\32\3\5\1\33\2\5\1\34"+
    "\7\5\1\35\1\0\1\36\1\0\1\5\1\0\1\37"+
    "\1\40\1\41\1\42\1\43\1\44\1\45\1\46\1\47"+
    "\1\5\1\50\1\51\1\52\1\53\1\54\1\55\1\5"+
    "\1\56\1\57\1\60\1\61\1\62\1\63\1\64\1\65"+
    "\1\66\1\67\1\1\1\70\u0182\0";

  private static int [] zzUnpackcmap_blocks() {
    int [] result = new int[512];
    int offset = 0;
    offset = zzUnpackcmap_blocks(ZZ_CMAP_BLOCKS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackcmap_blocks(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /**
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\0\1\1\1\2\1\1\1\3\1\1\1\4\1\5"+
    "\1\6\1\7\1\10\1\11\1\12\1\13\1\14\1\15"+
    "\1\16\1\17\1\20\1\21\1\22\7\1\1\23\1\24"+
    "\1\25\26\0\1\26\1\27\1\30\1\0\1\31\3\0"+
    "\1\32\2\0\1\33\23\0\1\34\1\0\1\35\1\0"+
    "\1\36\1\0\1\13\3\0\1\37\30\0\1\13\1\0"+
    "\1\40\1\0\1\41\31\0\1\42\1\43\1\44\5\0"+
    "\1\45\5\0\1\46\4\0\1\47\1\50\1\0\1\51"+
    "\10\0\1\52\1\53\6\0\1\54\3\0\1\55\1\56"+
    "\11\0\1\57\1\60\3\0\1\61\17\0\1\62\2\0"+
    "\1\63\1\64\11\0\1\65\4\0\1\66\1\0\1\67"+
    "\1\70\1\0\1\71\6\0\1\72\1\73";

  private static int [] zzUnpackAction() {
    int [] result = new int[257];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /**
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\71\0\71\0\162\0\253\0\344\0\u011d\0\71"+
    "\0\71\0\71\0\u0156\0\71\0\71\0\u018f\0\71\0\71"+
    "\0\u01c8\0\u0201\0\u023a\0\71\0\71\0\u0273\0\u02ac\0\u02e5"+
    "\0\u031e\0\u0357\0\u0390\0\u03c9\0\71\0\71\0\71\0\u0402"+
    "\0\u043b\0\u0474\0\u04ad\0\u04e6\0\u051f\0\u0558\0\u0591\0\u05ca"+
    "\0\u0603\0\u063c\0\u0675\0\u06ae\0\u06e7\0\u0720\0\u0759\0\u0792"+
    "\0\344\0\u07cb\0\u0804\0\u083d\0\u0876\0\71\0\71\0\71"+
    "\0\u08af\0\344\0\u08e8\0\u0921\0\u095a\0\344\0\u0993\0\u09cc"+
    "\0\71\0\u0a05\0\u0a3e\0\u0a77\0\u0ab0\0\u0ae9\0\u0b22\0\u0b5b"+
    "\0\u0b94\0\u0bcd\0\u0c06\0\u0c3f\0\u0c78\0\u0cb1\0\u0cea\0\u0d23"+
    "\0\u0d5c\0\u0d95\0\u0dce\0\u0e07\0\71\0\u0e40\0\71\0\u0e79"+
    "\0\344\0\u0eb2\0\u0876\0\u0eeb\0\u0f24\0\u0f5d\0\344\0\u0f96"+
    "\0\u0fcf\0\u1008\0\u1041\0\u107a\0\u10b3\0\u10ec\0\u1125\0\u115e"+
    "\0\u1197\0\u11d0\0\u1209\0\u1242\0\u127b\0\u12b4\0\u12ed\0\u1326"+
    "\0\u135f\0\u1398\0\u13d1\0\u140a\0\u1443\0\u147c\0\u14b5\0\71"+
    "\0\u14ee\0\344\0\u1527\0\344\0\u1560\0\u1599\0\u15d2\0\u160b"+
    "\0\u1644\0\u167d\0\u16b6\0\u16ef\0\u1728\0\u1761\0\u179a\0\u17d3"+
    "\0\u180c\0\u1845\0\u187e\0\u18b7\0\u18f0\0\u1929\0\u1962\0\u199b"+
    "\0\u19d4\0\u1a0d\0\u1a46\0\u1a7f\0\u1ab8\0\344\0\344\0\71"+
    "\0\u1af1\0\u1b2a\0\u1b63\0\u1b9c\0\u1bd5\0\71\0\u1c0e\0\u1c47"+
    "\0\u1c80\0\u1cb9\0\u1cf2\0\71\0\u1d2b\0\u1d64\0\u1d9d\0\u1dd6"+
    "\0\71\0\71\0\u1e0f\0\71\0\u1e48\0\u1e81\0\u1eba\0\u1ef3"+
    "\0\u1f2c\0\u1f65\0\u1f9e\0\u1fd7\0\71\0\71\0\u2010\0\u2049"+
    "\0\u2082\0\u20bb\0\u20f4\0\u212d\0\71\0\u2166\0\u219f\0\u21d8"+
    "\0\71\0\71\0\u2211\0\u224a\0\u2283\0\u22bc\0\u22f5\0\u232e"+
    "\0\u2367\0\u23a0\0\u23d9\0\71\0\71\0\u2412\0\u244b\0\u2484"+
    "\0\71\0\u24bd\0\u24f6\0\u252f\0\u2568\0\u25a1\0\u25da\0\u2613"+
    "\0\u264c\0\u2685\0\u26be\0\u26f7\0\u2730\0\u2769\0\u27a2\0\u27db"+
    "\0\71\0\u2814\0\u284d\0\71\0\71\0\u2886\0\u28bf\0\u28f8"+
    "\0\u2931\0\u296a\0\u29a3\0\u29dc\0\u2a15\0\u2a4e\0\71\0\u2a87"+
    "\0\u2ac0\0\u2af9\0\u2b32\0\71\0\u2b6b\0\71\0\71\0\u2ba4"+
    "\0\71\0\u2bdd\0\u2c16\0\u2c4f\0\u2c88\0\u2cc1\0\u2cfa\0\71"+
    "\0\71";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[257];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length() - 1;
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /**
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpacktrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\2\1\3\1\4\1\5\1\2\1\6\1\7\1\10"+
    "\1\2\1\11\1\12\1\13\1\14\1\15\1\16\1\17"+
    "\1\20\1\21\1\22\1\23\11\6\1\24\1\25\1\26"+
    "\2\6\1\27\1\30\1\31\2\6\1\32\10\6\1\33"+
    "\2\6\1\34\3\6\1\35\1\36\114\0\1\37\45\0"+
    "\3\40\1\0\1\41\33\40\1\42\1\43\1\44\1\40"+
    "\1\45\1\40\1\46\1\47\1\50\1\51\1\40\1\52"+
    "\1\40\1\53\1\40\1\54\1\55\1\40\1\56\1\40"+
    "\1\57\1\60\3\40\5\0\1\61\5\0\1\61\2\0"+
    "\1\61\5\0\5\61\1\62\3\61\2\0\30\61\15\0"+
    "\1\63\62\0\1\61\5\0\1\61\2\0\1\64\5\0"+
    "\5\61\1\62\3\61\2\0\30\61\7\0\1\61\5\0"+
    "\1\61\1\65\1\0\1\16\5\0\5\61\1\62\3\61"+
    "\2\0\30\61\24\0\1\66\70\0\1\67\70\0\1\70"+
    "\53\0\1\61\5\0\1\61\2\0\1\61\5\0\5\61"+
    "\1\62\3\61\2\0\20\61\1\71\7\61\7\0\1\61"+
    "\5\0\1\61\2\0\1\61\5\0\5\61\1\62\3\61"+
    "\2\0\15\61\1\72\12\61\7\0\1\61\5\0\1\61"+
    "\2\0\1\61\5\0\5\61\1\62\3\61\2\0\12\61"+
    "\1\73\15\61\7\0\1\61\5\0\1\61\2\0\1\61"+
    "\5\0\5\61\1\62\3\61\2\0\1\74\14\61\1\75"+
    "\12\61\7\0\1\61\5\0\1\61\2\0\1\61\5\0"+
    "\5\61\1\62\3\61\2\0\5\61\1\76\22\61\7\0"+
    "\1\61\5\0\1\61\2\0\1\61\5\0\5\61\1\62"+
    "\3\61\2\0\17\61\1\77\10\61\7\0\1\61\5\0"+
    "\1\61\2\0\1\61\5\0\5\61\1\62\3\61\2\0"+
    "\7\61\1\100\20\61\2\0\3\40\1\101\70\40\1\101"+
    "\12\40\1\102\5\40\5\102\6\40\6\102\27\40\1\101"+
    "\33\40\1\103\34\40\1\101\33\40\1\104\6\40\1\105"+
    "\5\40\1\106\17\40\1\101\33\40\1\107\3\40\1\110"+
    "\30\40\1\101\50\40\1\111\17\40\1\101\37\40\1\112"+
    "\30\40\1\101\35\40\1\113\32\40\1\101\37\40\1\114"+
    "\30\40\1\101\33\40\1\115\3\40\1\116\3\40\1\117"+
    "\24\40\1\101\33\40\1\120\34\40\1\101\50\40\1\121"+
    "\17\40\1\101\43\40\1\122\24\40\1\101\43\40\1\123"+
    "\24\40\1\101\33\40\1\124\34\40\1\125\20\40\1\126"+
    "\47\40\1\127\20\40\1\130\44\40\5\0\1\61\5\0"+
    "\1\61\2\0\1\61\5\0\3\61\1\131\1\61\1\62"+
    "\3\61\2\0\30\61\20\0\1\132\57\0\1\61\5\0"+
    "\1\61\1\65\1\0\1\64\5\0\5\61\1\62\3\61"+
    "\2\0\30\61\20\0\1\133\57\0\1\61\5\0\1\61"+
    "\2\0\1\61\5\0\5\61\1\62\3\61\2\0\10\61"+
    "\1\134\17\61\7\0\1\61\5\0\1\61\2\0\1\61"+
    "\5\0\5\61\1\62\3\61\2\0\20\61\1\135\7\61"+
    "\7\0\1\61\5\0\1\61\2\0\1\61\5\0\5\61"+
    "\1\62\3\61\2\0\12\61\1\136\15\61\7\0\1\61"+
    "\5\0\1\61\2\0\1\61\5\0\5\61\1\62\3\61"+
    "\2\0\17\61\1\137\10\61\7\0\1\61\5\0\1\61"+
    "\2\0\1\61\5\0\5\61\1\62\3\61\2\0\22\61"+
    "\1\140\5\61\7\0\1\61\5\0\1\61\2\0\1\61"+
    "\5\0\5\61\1\62\3\61\2\0\10\61\1\141\17\61"+
    "\2\0\3\40\1\101\12\40\1\142\5\40\5\142\6\40"+
    "\6\142\27\40\1\101\35\40\1\143\32\40\1\101\54\40"+
    "\1\144\13\40\1\101\33\40\1\145\34\40\1\101\45\40"+
    "\1\146\22\40\1\101\54\40\1\147\13\40\1\101\53\40"+
    "\1\150\14\40\1\101\47\40\1\151\1\152\17\40\1\101"+
    "\33\40\1\153\34\40\1\101\50\40\1\154\17\40\1\101"+
    "\61\40\1\155\6\40\1\101\34\40\1\156\33\40\1\101"+
    "\41\40\1\157\26\40\1\101\47\40\1\160\20\40\1\101"+
    "\46\40\1\161\21\40\1\101\43\40\1\162\24\40\1\101"+
    "\62\40\1\163\5\40\1\101\54\40\1\164\13\40\1\101"+
    "\45\40\1\165\22\40\1\101\60\40\1\166\7\40\1\101"+
    "\60\40\1\167\4\40\7\0\1\170\6\0\1\132\57\0"+
    "\1\61\5\0\1\61\2\0\1\61\5\0\5\61\1\62"+
    "\3\61\2\0\6\61\1\171\21\61\7\0\1\61\5\0"+
    "\1\61\2\0\1\61\5\0\5\61\1\62\3\61\2\0"+
    "\4\61\1\172\23\61\7\0\1\61\5\0\1\61\2\0"+
    "\1\61\5\0\5\61\1\62\3\61\2\0\20\61\1\173"+
    "\7\61\7\0\1\61\5\0\1\61\2\0\1\61\5\0"+
    "\5\61\1\62\3\61\2\0\4\61\1\174\23\61\7\0"+
    "\1\61\5\0\1\61\2\0\1\61\5\0\5\61\1\62"+
    "\3\61\2\0\12\61\1\175\15\61\2\0\3\40\1\101"+
    "\12\40\1\176\5\40\5\176\6\40\6\176\27\40\1\101"+
    "\44\40\1\177\23\40\1\101\37\40\1\200\30\40\1\101"+
    "\52\40\1\201\15\40\1\101\50\40\1\202\17\40\1\101"+
    "\33\40\1\203\34\40\1\101\35\40\1\204\32\40\1\101"+
    "\54\40\1\205\13\40\1\101\54\40\1\206\13\40\1\101"+
    "\36\40\1\207\31\40\1\101\47\40\1\210\20\40\1\101"+
    "\57\40\1\211\10\40\1\101\37\40\1\212\30\40\1\101"+
    "\37\40\1\213\30\40\1\101\37\40\1\214\4\40\1\215"+
    "\23\40\1\101\37\40\1\216\30\40\1\101\47\40\1\217"+
    "\20\40\1\101\37\40\1\220\30\40\1\101\45\40\1\221"+
    "\22\40\1\101\55\40\1\222\12\40\1\101\43\40\1\223"+
    "\24\40\1\101\43\40\1\224\21\40\5\0\1\61\5\0"+
    "\1\61\2\0\1\61\5\0\5\61\1\62\3\61\2\0"+
    "\1\225\27\61\7\0\1\61\5\0\1\61\2\0\1\61"+
    "\5\0\5\61\1\62\3\61\2\0\4\61\1\226\23\61"+
    "\7\0\1\61\5\0\1\61\2\0\1\61\5\0\5\61"+
    "\1\62\3\61\2\0\4\61\1\227\23\61\2\0\3\40"+
    "\1\230\12\40\1\231\5\40\5\231\6\40\6\231\27\40"+
    "\1\101\41\40\1\232\26\40\1\101\41\40\1\233\26\40"+
    "\1\101\54\40\1\234\13\40\1\101\52\40\1\235\15\40"+
    "\1\236\70\40\1\101\52\40\1\237\15\40\1\101\24\40"+
    "\1\240\3\40\1\241\37\40\1\101\37\40\1\242\30\40"+
    "\1\101\37\40\1\243\30\40\1\244\70\40\1\101\50\40"+
    "\1\245\17\40\1\101\45\40\1\246\22\40\1\101\47\40"+
    "\1\247\20\40\1\101\30\40\1\250\37\40\1\251\70\40"+
    "\1\252\70\40\1\101\54\40\1\253\13\40\1\254\70\40"+
    "\1\101\37\40\1\255\30\40\1\101\37\40\1\256\30\40"+
    "\1\101\53\40\1\257\14\40\1\101\53\40\1\260\11\40"+
    "\5\0\1\61\5\0\1\61\2\0\1\61\5\0\5\61"+
    "\1\62\3\61\2\0\14\61\1\261\13\61\2\0\3\40"+
    "\1\101\12\40\1\262\5\40\5\262\6\40\6\262\27\40"+
    "\1\101\52\40\1\263\15\40\1\101\50\40\1\264\17\40"+
    "\1\265\70\40\1\266\70\40\1\101\43\40\1\267\24\40"+
    "\1\101\33\40\1\270\34\40\1\101\43\40\1\271\24\40"+
    "\1\101\52\40\1\272\15\40\1\101\52\40\1\273\15\40"+
    "\1\101\52\40\1\274\15\40\1\275\70\40\1\101\36\40"+
    "\1\276\31\40\1\101\54\40\1\277\13\40\1\101\53\40"+
    "\1\300\14\40\1\301\70\40\1\302\70\40\1\101\26\40"+
    "\1\303\41\40\1\101\26\40\1\304\36\40\5\0\1\61"+
    "\5\0\1\61\2\0\1\61\5\0\5\61\1\62\3\61"+
    "\2\0\2\61\1\305\25\61\2\0\3\40\1\101\12\40"+
    "\1\306\5\40\5\306\6\40\6\306\27\40\1\101\50\40"+
    "\1\307\17\40\1\101\52\40\1\310\15\40\1\101\51\40"+
    "\1\311\16\40\1\101\46\40\1\312\21\40\1\101\62\40"+
    "\1\313\5\40\1\314\70\40\1\315\70\40\1\101\36\40"+
    "\1\316\31\40\1\101\27\40\1\317\40\40\1\101\61\40"+
    "\1\320\6\40\1\321\70\40\1\101\33\40\1\322\34\40"+
    "\1\101\33\40\1\323\31\40\5\0\1\61\5\0\1\61"+
    "\2\0\1\61\5\0\5\61\1\62\3\61\2\0\10\61"+
    "\1\324\17\61\2\0\3\40\1\230\70\40\1\101\55\40"+
    "\1\325\12\40\1\101\61\40\1\326\6\40\1\101\54\40"+
    "\1\327\13\40\1\101\43\40\1\330\24\40\1\101\37\40"+
    "\1\331\30\40\1\101\53\40\1\332\14\40\1\101\50\40"+
    "\1\333\17\40\1\101\45\40\1\334\22\40\1\101\34\40"+
    "\1\335\33\40\1\101\34\40\1\336\30\40\5\0\1\61"+
    "\5\0\1\61\2\0\1\61\5\0\5\61\1\62\3\61"+
    "\2\0\15\61\1\337\12\61\2\0\3\40\1\101\47\40"+
    "\1\340\20\40\1\341\70\40\1\101\43\40\1\342\24\40"+
    "\1\101\45\40\1\343\22\40\1\344\70\40\1\345\70\40"+
    "\1\101\53\40\1\346\14\40\1\101\37\40\1\347\30\40"+
    "\1\101\37\40\1\350\30\40\1\101\37\40\1\351\25\40"+
    "\5\0\1\61\5\0\1\61\2\0\1\61\5\0\5\61"+
    "\1\62\3\61\2\0\14\61\1\352\13\61\2\0\3\40"+
    "\1\101\36\40\1\353\31\40\1\101\50\40\1\354\17\40"+
    "\1\101\61\40\1\355\6\40\1\101\43\40\1\356\24\40"+
    "\1\357\70\40\1\101\45\40\1\360\22\40\1\101\45\40"+
    "\1\361\17\40\5\0\1\61\2\0\1\14\2\0\1\61"+
    "\2\0\1\61\5\0\5\61\1\62\3\61\2\0\30\61"+
    "\2\0\3\40\1\101\22\40\1\362\45\40\1\101\47\40"+
    "\1\363\20\40\1\364\70\40\1\101\54\40\1\365\13\40"+
    "\1\366\70\40\1\367\70\40\1\101\50\40\1\370\17\40"+
    "\1\371\70\40\1\101\43\40\1\372\24\40\1\101\45\40"+
    "\1\373\22\40\1\101\50\40\1\374\17\40\1\101\50\40"+
    "\1\375\17\40\1\101\47\40\1\376\20\40\1\101\52\40"+
    "\1\377\15\40\1\u0100\70\40\1\u0101\65\40";

  private static int [] zzUnpacktrans() {
    int [] result = new int[11571];
    int offset = 0;
    offset = zzUnpacktrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpacktrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** Error code for "Unknown internal scanner error". */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  /** Error code for "could not match input". */
  private static final int ZZ_NO_MATCH = 1;
  /** Error code for "pushback value was too large". */
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /**
   * Error messages for {@link #ZZ_UNKNOWN_ERROR}, {@link #ZZ_NO_MATCH}, and
   * {@link #ZZ_PUSHBACK_2BIG} respectively.
   */
  private static final String ZZ_ERROR_MSG[] = {
    "Unknown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state {@code aState}
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\1\0\2\11\4\1\3\11\1\1\2\11\1\1\2\11"+
    "\3\1\2\11\7\1\3\11\26\0\3\11\1\0\1\1"+
    "\3\0\1\1\2\0\1\11\23\0\1\11\1\0\1\11"+
    "\1\0\1\1\1\0\1\1\3\0\1\1\30\0\1\11"+
    "\1\0\1\1\1\0\1\1\31\0\2\1\1\11\5\0"+
    "\1\11\5\0\1\11\4\0\2\11\1\0\1\11\10\0"+
    "\2\11\6\0\1\11\3\0\2\11\11\0\2\11\3\0"+
    "\1\11\17\0\1\11\2\0\2\11\11\0\1\11\4\0"+
    "\1\11\1\0\2\11\1\0\1\11\6\0\2\11";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[257];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** Input device. */
  private java.io.Reader zzReader;

  /** Current state of the DFA. */
  private int zzState;

  /** Current lexical state. */
  private int zzLexicalState = YYINITIAL;

  /**
   * This buffer contains the current text to be matched and is the source of the {@link #yytext()}
   * string.
   */
  private char zzBuffer[] = new char[Math.min(ZZ_BUFFERSIZE, zzMaxBufferLen())];

  /** Text position at the last accepting state. */
  private int zzMarkedPos;

  /** Current text position in the buffer. */
  private int zzCurrentPos;

  /** Marks the beginning of the {@link #yytext()} string in the buffer. */
  private int zzStartRead;

  /** Marks the last character in the buffer, that has been read from input. */
  private int zzEndRead;

  /**
   * Whether the scanner is at the end of file.
   * @see #yyatEOF
   */
  private boolean zzAtEOF;

  /**
   * The number of occupied positions in {@link #zzBuffer} beyond {@link #zzEndRead}.
   *
   * <p>When a lead/high surrogate has been read from the input stream into the final
   * {@link #zzBuffer} position, this will have a value of 1; otherwise, it will have a value of 0.
   */
  private int zzFinalHighSurrogate = 0;

  /** Number of newlines encountered up to the start of the matched text. */
  private int yyline;

  /** Number of characters from the last newline up to the start of the matched text. */
  private int yycolumn;

  /** Number of characters up to the start of the matched text. */
  @SuppressWarnings("unused")
  private long yychar;

  /** Whether the scanner is currently at the beginning of a line. */
  @SuppressWarnings("unused")
  private boolean zzAtBOL = true;

  /** Whether the user-EOF-code has already been executed. */
  private boolean zzEOFDone;

  /* user code: */

  private Symbol symbol(int type) {
    return new Symbol(type, yyline+1, yycolumn+1);
  }

  private Symbol symbol(int type, Object value) {
    return new Symbol(type, yyline+1, yycolumn+1, value);
  }


    private void error(String message) {
      System.out.println("Error en linea line "+(yyline+1)+", columna "+(yycolumn+1)+" : "+message);
    }




  /**
   * Creates a new scanner
   *
   * @param   in  the java.io.Reader to read input from.
   */
  public analizadorLexico(java.io.Reader in) {
    this.zzReader = in;
  }


  /** Returns the maximum size of the scanner buffer, which limits the size of tokens. */
  private int zzMaxBufferLen() {
    return Integer.MAX_VALUE;
  }

  /**  Whether the scanner buffer can grow to accommodate a larger token. */
  private boolean zzCanGrow() {
    return true;
  }

  /**
   * Translates raw input code points to DFA table row
   */
  private static int zzCMap(int input) {
    int offset = input & 255;
    return offset == input ? ZZ_CMAP_BLOCKS[offset] : ZZ_CMAP_BLOCKS[ZZ_CMAP_TOP[input >> 8] | offset];
  }

  /**
   * Refills the input buffer.
   *
   * @return {@code false} iff there was new input.
   * @exception java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead - zzStartRead);

      /* translate stored positions */
      zzEndRead -= zzStartRead;
      zzCurrentPos -= zzStartRead;
      zzMarkedPos -= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length - zzFinalHighSurrogate && zzCanGrow()) {
      /* if not, and it can grow: blow it up */
      char newBuffer[] = new char[Math.min(zzBuffer.length * 2, zzMaxBufferLen())];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
    }

    /* fill the buffer with new input */
    int requested = zzBuffer.length - zzEndRead;
    int numRead = zzReader.read(zzBuffer, zzEndRead, requested);

    /* not supposed to occur according to specification of java.io.Reader */
    if (numRead == 0) {
      if (requested == 0) {
        throw new java.io.EOFException("Scan buffer limit reached ["+zzBuffer.length+"]");
      }
      else {
        throw new java.io.IOException(
            "Reader returned 0 characters. See JFlex examples/zero-reader for a workaround.");
      }
    }
    if (numRead > 0) {
      zzEndRead += numRead;
      if (Character.isHighSurrogate(zzBuffer[zzEndRead - 1])) {
        if (numRead == requested) { // We requested too few chars to encode a full Unicode character
          --zzEndRead;
          zzFinalHighSurrogate = 1;
        } else {                    // There is room in the buffer for at least one more char
          int c = zzReader.read();  // Expecting to read a paired low surrogate char
          if (c == -1) {
            return true;
          } else {
            zzBuffer[zzEndRead++] = (char)c;
          }
        }
      }
      /* potentially more input available */
      return false;
    }

    /* numRead < 0 ==> end of stream */
    return true;
  }


  /**
   * Closes the input reader.
   *
   * @throws java.io.IOException if the reader could not be closed.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true; // indicate end of file
    zzEndRead = zzStartRead; // invalidate buffer

    if (zzReader != null) {
      zzReader.close();
    }
  }


  /**
   * Resets the scanner to read from a new input stream.
   *
   * <p>Does not close the old reader.
   *
   * <p>All internal variables are reset, the old input stream <b>cannot</b> be reused (internal
   * buffer is discarded and lost). Lexical state is set to {@code ZZ_INITIAL}.
   *
   * <p>Internal scan buffer is resized down to its initial length, if it has grown.
   *
   * @param reader The new input stream.
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzEOFDone = false;
    yyResetPosition();
    zzLexicalState = YYINITIAL;
    int initBufferSize = Math.min(ZZ_BUFFERSIZE, zzMaxBufferLen());
    if (zzBuffer.length > initBufferSize) {
      zzBuffer = new char[initBufferSize];
    }
  }

  /**
   * Resets the input position.
   */
  private final void yyResetPosition() {
      zzAtBOL  = true;
      zzAtEOF  = false;
      zzCurrentPos = 0;
      zzMarkedPos = 0;
      zzStartRead = 0;
      zzEndRead = 0;
      zzFinalHighSurrogate = 0;
      yyline = 0;
      yycolumn = 0;
      yychar = 0L;
  }


  /**
   * Returns whether the scanner has reached the end of the reader it reads from.
   *
   * @return whether the scanner has reached EOF.
   */
  public final boolean yyatEOF() {
    return zzAtEOF;
  }


  /**
   * Returns the current lexical state.
   *
   * @return the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state.
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   *
   * @return the matched text.
   */
  public final String yytext() {
    return new String(zzBuffer, zzStartRead, zzMarkedPos-zzStartRead);
  }


  /**
   * Returns the character at the given position from the matched text.
   *
   * <p>It is equivalent to {@code yytext().charAt(pos)}, but faster.
   *
   * @param position the position of the character to fetch. A value from 0 to {@code yylength()-1}.
   *
   * @return the character at {@code position}.
   */
  public final char yycharat(int position) {
    return zzBuffer[zzStartRead + position];
  }


  /**
   * How many characters were matched.
   *
   * @return the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occurred while scanning.
   *
   * <p>In a well-formed scanner (no or only correct usage of {@code yypushback(int)} and a
   * match-all fallback rule) this method will only be called with things that
   * "Can't Possibly Happen".
   *
   * <p>If this method is called, something is seriously wrong (e.g. a JFlex bug producing a faulty
   * scanner etc.).
   *
   * <p>Usual syntax/scanner level error handling should be done in error fallback rules.
   *
   * @param errorCode the code of the error message to display.
   */
  private static void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    } catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  }


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * <p>They will be read again by then next call of the scanning method.
   *
   * @param number the number of characters to be read again. This number must not be greater than
   *     {@link #yylength()}.
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Contains user EOF-code, which will be executed exactly once,
   * when the end of file is reached
   */
  private void zzDoEOF() throws java.io.IOException {
    if (!zzEOFDone) {
      zzEOFDone = true;
    
  yyclose();    }
  }




  /**
   * Resumes scanning until the next regular expression is matched, the end of input is encountered
   * or an I/O-Error occurs.
   *
   * @return the next token.
   * @exception java.io.IOException if any I/O-Error occurs.
   */
  @Override  public java_cup.runtime.Symbol next_token() throws java.io.IOException
  {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char[] zzBufferL = zzBuffer;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      boolean zzR = false;
      int zzCh;
      int zzCharCount;
      for (zzCurrentPosL = zzStartRead  ;
           zzCurrentPosL < zzMarkedPosL ;
           zzCurrentPosL += zzCharCount ) {
        zzCh = Character.codePointAt(zzBufferL, zzCurrentPosL, zzMarkedPosL);
        zzCharCount = Character.charCount(zzCh);
        switch (zzCh) {
        case '\u000B':  // fall through
        case '\u000C':  // fall through
        case '\u0085':  // fall through
        case '\u2028':  // fall through
        case '\u2029':
          yyline++;
          yycolumn = 0;
          zzR = false;
          break;
        case '\r':
          yyline++;
          yycolumn = 0;
          zzR = true;
          break;
        case '\n':
          if (zzR)
            zzR = false;
          else {
            yyline++;
            yycolumn = 0;
          }
          break;
        default:
          zzR = false;
          yycolumn += zzCharCount;
        }
      }

      if (zzR) {
        // peek one character ahead if it is
        // (if we have counted one line too much)
        boolean zzPeek;
        if (zzMarkedPosL < zzEndReadL)
          zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        else if (zzAtEOF)
          zzPeek = false;
        else {
          boolean eof = zzRefill();
          zzEndReadL = zzEndRead;
          zzMarkedPosL = zzMarkedPos;
          zzBufferL = zzBuffer;
          if (eof)
            zzPeek = false;
          else
            zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        }
        if (zzPeek) yyline--;
      }
      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;

      zzState = ZZ_LEXSTATE[zzLexicalState];

      // set up zzAction for empty match case:
      int zzAttributes = zzAttrL[zzState];
      if ( (zzAttributes & 1) == 1 ) {
        zzAction = zzState;
      }


      zzForAction: {
        while (true) {

          if (zzCurrentPosL < zzEndReadL) {
            zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
            zzCurrentPosL += Character.charCount(zzInput);
          }
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
              zzCurrentPosL += Character.charCount(zzInput);
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMap(zzInput) ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
        zzAtEOF = true;
            zzDoEOF();
              {
                return symbol(sym.EOF);
              }
      }
      else {
        switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
          case 1:
            { error("Simbolo invalido <"+ yytext()+">");
            }
          // fall through
          case 60: break;
          case 2:
            { /*Ignore*/
            }
          // fall through
          case 61: break;
          case 3:
            { return symbol(sym.COMILLA, yytext()  );
            }
          // fall through
          case 62: break;
          case 4:
            { return symbol(sym.PARENTESIS_A, yytext());
            }
          // fall through
          case 63: break;
          case 5:
            { return symbol(sym.PARENTESIS_C, yytext());
            }
          // fall through
          case 64: break;
          case 6:
            { return symbol(sym.MAS, yytext());
            }
          // fall through
          case 65: break;
          case 7:
            { return symbol(sym.COMA, yytext());
            }
          // fall through
          case 66: break;
          case 8:
            { return symbol(sym.MENOS, yytext());
            }
          // fall through
          case 67: break;
          case 9:
            { return symbol(sym.ASTERISCO, yytext());
            }
          // fall through
          case 68: break;
          case 10:
            { return symbol(sym.BARRA, yytext());
            }
          // fall through
          case 69: break;
          case 11:
            { return symbol(sym.CONSTANTE,  yytext()  );
            }
          // fall through
          case 70: break;
          case 12:
            { return symbol(sym.DOS_PUNTOS, yytext());
            }
          // fall through
          case 71: break;
          case 13:
            { return symbol(sym.PUNTO_COMA, yytext());
            }
          // fall through
          case 72: break;
          case 14:
            { return symbol(sym.MENOR_QUE, yytext());
            }
          // fall through
          case 73: break;
          case 15:
            { return symbol(sym.IGUAL, yytext());
            }
          // fall through
          case 74: break;
          case 16:
            { return symbol(sym.MAYOR_QUE, yytext());
            }
          // fall through
          case 75: break;
          case 17:
            { return symbol(sym.CORCHETE_A, yytext());
            }
          // fall through
          case 76: break;
          case 18:
            { return symbol(sym.CORCHETE_C, yytext());
            }
          // fall through
          case 77: break;
          case 19:
            { return symbol(sym.LLAVE_A, yytext());
            }
          // fall through
          case 78: break;
          case 20:
            { return symbol(sym.LLAVE_C, yytext());
            }
          // fall through
          case 79: break;
          case 21:
            { return symbol(sym.DIFERENTE, yytext());
            }
          // fall through
          case 80: break;
          case 22:
            { return symbol(sym.MENOR_IGUAL, yytext());
            }
          // fall through
          case 81: break;
          case 23:
            { return symbol(sym.IGUAL_IGUAL, yytext());
            }
          // fall through
          case 82: break;
          case 24:
            { return symbol(sym.MAYOR_IGUAL, yytext());
            }
          // fall through
          case 83: break;
          case 25:
            { return symbol(sym.DO, yytext());
            }
          // fall through
          case 84: break;
          case 26:
            { return symbol(sym.IF, yytext());
            }
          // fall through
          case 85: break;
          case 27:
            { return symbol(sym.CADENA, yytext().substring(1, yytext().length() - 1));
            }
          // fall through
          case 86: break;
          case 28:
            { return symbol(sym.X, yytext());
            }
          // fall through
          case 87: break;
          case 29:
            { return symbol(sym.Y, yytext());
            }
          // fall through
          case 88: break;
          case 30:
            { return symbol(sym.IDENTIFICADOR, yytext());
            }
          // fall through
          case 89: break;
          case 31:
            { return symbol(sym.FOR, yytext());
            }
          // fall through
          case 90: break;
          case 32:
            { return symbol(sym.ELSE, yytext());
            }
          // fall through
          case 91: break;
          case 33:
            { return symbol(sym.TRUE, yytext());
            }
          // fall through
          case 92: break;
          case 34:
            { return symbol(sym.FALSE, yytext());
            }
          // fall through
          case 93: break;
          case 35:
            { return symbol(sym.WHILE, yytext());
            }
          // fall through
          case 94: break;
          case 36:
            { return symbol(sym.HEXADECIMAL, yytext());
            }
          // fall through
          case 95: break;
          case 37:
            { return symbol(sym.DATA, yytext());
            }
          // fall through
          case 96: break;
          case 38:
            { return symbol(sym.ICON, yytext());
            }
          // fall through
          case 97: break;
          case 39:
            { return symbol(sym.LINK, yytext());
            }
          // fall through
          case 98: break;
          case 40:
            { return symbol(sym.NAME, yytext());
            }
          // fall through
          case 99: break;
          case 41:
            { return symbol(sym.SIZE, yytext());
            }
          // fall through
          case 100: break;
          case 42:
            { return symbol(sym.CHART, yytext());
            }
          // fall through
          case 101: break;
          case 43:
            { return symbol(sym.COLOR, yytext());
            }
          // fall through
          case 102: break;
          case 44:
            { return symbol(sym.LABEL, yytext());
            }
          // fall through
          case 103: break;
          case 45:
            { return symbol(sym.TITLE, yytext());
            }
          // fall through
          case 104: break;
          case 46:
            { return symbol(sym.VALUE, yytext());
            }
          // fall through
          case 105: break;
          case 47:
            { return symbol(sym.FOOTER, yytext());
            }
          // fall through
          case 106: break;
          case 48:
            { return symbol(sym.HEADER, yytext());
            }
          // fall through
          case 107: break;
          case 49:
            { return symbol(sym.POINTS, yytext());
            }
          // fall through
          case 108: break;
          case 50:
            { return symbol(sym.CATEGORY, yytext());
            }
          // fall through
          case 109: break;
          case 51:
            { return symbol(sym.FONT_SIZE, yytext());
            }
          // fall through
          case 110: break;
          case 52:
            { return symbol(sym.KEYWORDS, yytext());
            }
          // fall through
          case 111: break;
          case 53:
            { return symbol(sym.LINE_STYLE, yytext());
            }
          // fall through
          case 112: break;
          case 54:
            { return symbol(sym.FONT_FAMILY, yytext());
            }
          // fall through
          case 113: break;
          case 55:
            { return symbol(sym.X_AXIS_LABEL, yytext());
            }
          // fall through
          case 114: break;
          case 56:
            { return symbol(sym.Y_AXIS_LABEL, yytext());
            }
          // fall through
          case 115: break;
          case 57:
            { return symbol(sym.DESCRIPTION, yytext());
            }
          // fall through
          case 116: break;
          case 58:
            { return symbol(sym.LEGEND_POSITION, yytext());
            }
          // fall through
          case 117: break;
          case 59:
            { return symbol(sym.BACKGROUND_COLOR, yytext());
            }
          // fall through
          case 118: break;
          default:
            zzScanError(ZZ_NO_MATCH);
        }
      }
    }
  }


}
