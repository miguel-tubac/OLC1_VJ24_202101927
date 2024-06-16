// DO NOT EDIT
// Generated by JFlex 1.9.1 http://jflex.de/
// source: src/Analizadores/Lexer.jflex

// ------------  Paquete e importaciones ------------
package Analizadores; 

import InterfasGrafica.FrameInicio;
import java_cup.runtime.*;
import java.util.LinkedList;
import Excepciones.Errores;


@SuppressWarnings("fallthrough")
public class Lexer implements java_cup.runtime.Scanner {

  /** This character denotes the end of file. */
  public static final int YYEOF = -1;

  /** Initial size of the lookahead buffer. */
  private static final int ZZ_BUFFERSIZE = 16384;

  // Lexical states.
  public static final int YYINITIAL = 0;
  public static final int CADENA = 2;
  public static final int CARACTER = 4;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = {
     0,  0,  1,  1,  2, 2
  };

  /**
   * Top-level table for translating characters to character classes
   */
  private static final int [] ZZ_CMAP_TOP = zzUnpackcmap_top();

  private static final String ZZ_CMAP_TOP_PACKED_0 =
    "\1\0\1\u0100\36\u0200\1\u0300\1\u0400\266\u0200\10\u0500\u1020\u0200";

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
    "\11\0\1\1\1\2\1\3\2\2\22\0\1\1\1\4"+
    "\1\5\2\0\1\6\1\7\1\10\1\11\1\12\1\13"+
    "\1\14\1\15\1\16\1\17\1\20\12\21\1\22\1\23"+
    "\1\24\1\25\1\26\2\0\1\27\1\30\1\31\1\32"+
    "\1\33\1\34\1\35\1\36\1\37\1\40\1\41\1\42"+
    "\1\43\1\44\1\45\1\46\1\40\1\47\1\50\1\51"+
    "\1\52\1\53\1\54\3\40\1\55\1\56\1\57\1\60"+
    "\1\61\1\0\1\27\1\30\1\31\1\32\1\33\1\34"+
    "\1\35\1\36\1\37\1\40\1\41\1\42\1\43\1\44"+
    "\1\45\1\46\1\40\1\47\1\50\1\51\1\52\1\53"+
    "\1\54\3\40\1\62\1\63\1\64\7\0\1\3\252\0"+
    "\2\65\115\0\1\66\u01a8\0\2\3\u0100\0\1\67\325\0"+
    "\u0100\3";

  private static int [] zzUnpackcmap_blocks() {
    int [] result = new int[1536];
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
    "\3\0\1\1\1\2\1\3\1\4\1\5\1\1\1\6"+
    "\1\7\1\10\1\11\1\12\1\13\1\14\1\15\1\16"+
    "\1\17\1\20\1\21\1\22\1\23\16\24\1\25\1\26"+
    "\1\27\1\30\1\31\1\1\1\32\2\1\1\33\1\34"+
    "\1\0\1\35\1\36\1\0\1\37\1\40\1\41\1\42"+
    "\1\43\1\0\1\44\1\0\1\45\1\46\1\47\1\50"+
    "\1\51\4\24\1\52\3\24\1\53\10\24\1\54\1\53"+
    "\2\0\1\55\1\56\1\57\1\60\1\61\1\62\1\63"+
    "\1\64\1\65\1\66\1\67\1\70\1\0\1\71\6\24"+
    "\1\0\1\24\1\72\1\73\2\24\1\0\3\24\1\74"+
    "\1\24\1\0\1\73\1\0\1\44\1\75\1\24\1\76"+
    "\2\24\1\0\1\24\2\77\1\24\1\0\2\24\1\0"+
    "\2\24\1\0\1\100\1\24\1\0\2\101\1\102\1\24"+
    "\1\0\1\102\1\24\2\103\1\104\1\24\1\0\2\24"+
    "\1\0\2\105\1\24\1\0\1\106\1\24\1\0\1\107"+
    "\2\110\1\24\1\0\2\111\2\112";

  private static int [] zzUnpackAction() {
    int [] result = new int[173];
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
    "\0\0\0\70\0\160\0\250\0\250\0\340\0\250\0\250"+
    "\0\u0118\0\250\0\250\0\250\0\u0150\0\u0188\0\250\0\u01c0"+
    "\0\u01f8\0\u0230\0\u0268\0\250\0\u02a0\0\u02d8\0\u0310\0\u0348"+
    "\0\u0380\0\u03b8\0\u03f0\0\u0428\0\u0460\0\u0498\0\u04d0\0\u0508"+
    "\0\u0540\0\u0578\0\u05b0\0\u05e8\0\u0620\0\250\0\250\0\250"+
    "\0\250\0\250\0\u0658\0\250\0\u0690\0\u06c8\0\250\0\250"+
    "\0\u0700\0\250\0\250\0\u0738\0\250\0\250\0\250\0\250"+
    "\0\250\0\u0770\0\u07a8\0\u07e0\0\250\0\250\0\250\0\250"+
    "\0\250\0\u0818\0\u0850\0\u0888\0\u08c0\0\u08f8\0\u0930\0\u0968"+
    "\0\u09a0\0\u0348\0\u09d8\0\u0a10\0\u0a48\0\u0a80\0\u0ab8\0\u0af0"+
    "\0\u0b28\0\u0b60\0\250\0\250\0\u0b98\0\u0bd0\0\250\0\250"+
    "\0\250\0\250\0\250\0\250\0\250\0\250\0\250\0\250"+
    "\0\250\0\250\0\u0c08\0\u07e0\0\u0c40\0\u0c78\0\u0cb0\0\u0ce8"+
    "\0\u0d20\0\u0d58\0\u0d90\0\u0dc8\0\u0348\0\u0348\0\u0e00\0\u0e38"+
    "\0\u0e70\0\u0ea8\0\u0ee0\0\u0f18\0\u0348\0\u0f50\0\u0f88\0\250"+
    "\0\u0fc0\0\250\0\u0348\0\u0ff8\0\u0348\0\u1030\0\u1068\0\u10a0"+
    "\0\u10d8\0\u0348\0\250\0\u1110\0\u1148\0\u1180\0\u11b8\0\u11f0"+
    "\0\u1228\0\u1260\0\u1298\0\u0348\0\u12d0\0\u1308\0\u0348\0\250"+
    "\0\u0348\0\u1340\0\u1378\0\250\0\u13b0\0\u0348\0\250\0\u0348"+
    "\0\u13e8\0\u1420\0\u1458\0\u1490\0\u14c8\0\u0348\0\250\0\u1500"+
    "\0\u1538\0\u0348\0\u1570\0\u15a8\0\u0348\0\u0348\0\250\0\u15e0"+
    "\0\u1618\0\u0348\0\250\0\u0348\0\250";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[173];
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
    "\1\4\2\5\1\0\1\6\1\7\1\10\1\11\1\12"+
    "\1\13\1\14\1\15\1\16\1\17\1\20\1\4\1\21"+
    "\1\22\1\23\1\24\1\25\1\26\1\27\1\30\1\31"+
    "\1\32\1\33\1\34\1\35\2\30\1\36\3\30\1\37"+
    "\2\30\1\40\1\41\1\42\1\43\1\30\1\44\1\45"+
    "\1\46\1\4\1\47\1\50\1\51\1\52\1\53\1\54"+
    "\1\55\1\56\1\4\5\57\1\60\50\57\1\61\11\57"+
    "\10\62\1\63\45\62\1\64\11\62\115\0\1\65\51\0"+
    "\1\66\73\0\1\67\70\0\1\70\71\0\1\71\64\0"+
    "\1\72\4\0\1\73\66\0\1\74\1\0\1\22\70\0"+
    "\1\75\72\0\1\76\67\0\1\77\1\100\66\0\1\101"+
    "\63\0\1\30\5\0\26\30\4\0\1\30\27\0\1\30"+
    "\5\0\16\30\1\102\1\30\1\103\5\30\4\0\1\30"+
    "\27\0\1\30\5\0\7\30\1\104\6\30\1\105\7\30"+
    "\4\0\1\30\27\0\1\30\5\0\16\30\1\106\7\30"+
    "\4\0\1\30\27\0\1\30\5\0\13\30\1\107\12\30"+
    "\4\0\1\30\27\0\1\30\5\0\1\110\15\30\1\111"+
    "\7\30\4\0\1\30\27\0\1\30\5\0\5\30\1\112"+
    "\7\30\1\113\10\30\4\0\1\30\27\0\1\30\5\0"+
    "\1\114\25\30\4\0\1\30\27\0\1\30\5\0\20\30"+
    "\1\115\5\30\4\0\1\30\27\0\1\30\5\0\4\30"+
    "\1\116\21\30\4\0\1\30\27\0\1\30\5\0\22\30"+
    "\1\117\3\30\4\0\1\30\27\0\1\30\5\0\20\30"+
    "\1\120\5\30\4\0\1\30\27\0\1\30\5\0\1\121"+
    "\25\30\4\0\1\30\27\0\1\30\5\0\7\30\1\122"+
    "\16\30\4\0\1\30\71\0\1\123\40\0\1\124\7\0"+
    "\1\125\74\0\1\126\23\0\1\127\2\0\1\130\33\0"+
    "\1\131\2\0\1\132\1\0\1\133\4\0\1\134\16\0"+
    "\1\135\2\0\1\136\33\0\1\137\2\0\1\140\1\0"+
    "\1\141\4\0\1\142\11\0\13\72\1\143\54\72\2\73"+
    "\2\0\64\73\21\0\1\144\67\0\1\30\5\0\16\30"+
    "\1\145\7\30\4\0\1\30\27\0\1\30\5\0\4\30"+
    "\1\146\21\30\4\0\1\30\27\0\1\30\5\0\1\147"+
    "\25\30\4\0\1\30\27\0\1\30\5\0\15\30\1\150"+
    "\10\30\4\0\1\30\27\0\1\30\5\0\23\30\1\151"+
    "\2\30\4\0\1\30\27\0\1\30\5\0\21\30\1\152"+
    "\4\30\4\0\1\30\4\0\1\153\22\0\1\30\5\0"+
    "\13\30\1\154\12\30\4\0\1\30\27\0\1\30\5\0"+
    "\20\30\1\155\5\30\4\0\1\30\27\0\1\30\5\0"+
    "\22\30\1\156\3\30\4\0\1\30\27\0\1\30\5\0"+
    "\22\30\1\157\3\30\4\0\1\30\27\0\1\30\5\0"+
    "\10\30\1\160\15\30\4\0\1\30\3\0\1\161\23\0"+
    "\1\30\5\0\22\30\1\162\3\30\4\0\1\30\27\0"+
    "\1\30\5\0\20\30\1\163\5\30\4\0\1\30\27\0"+
    "\1\30\5\0\23\30\1\164\2\30\4\0\1\30\27\0"+
    "\1\30\5\0\20\30\1\165\5\30\4\0\1\30\27\0"+
    "\1\30\5\0\10\30\1\166\15\30\4\0\1\30\3\0"+
    "\1\167\53\0\1\170\65\0\1\171\20\0\13\72\1\143"+
    "\4\72\1\172\47\72\21\0\1\30\5\0\13\30\1\173"+
    "\12\30\4\0\1\30\27\0\1\30\5\0\1\174\25\30"+
    "\4\0\1\30\27\0\1\30\5\0\20\30\1\175\5\30"+
    "\4\0\1\30\27\0\1\30\5\0\21\30\1\176\1\177"+
    "\3\30\4\0\1\30\4\0\1\200\22\0\1\30\5\0"+
    "\1\30\1\201\24\30\4\0\1\30\27\0\1\30\5\0"+
    "\4\30\1\202\21\30\4\0\1\30\41\0\1\203\55\0"+
    "\1\30\5\0\21\30\1\204\4\30\4\0\1\30\4\0"+
    "\1\205\22\0\1\30\5\0\2\30\1\206\23\30\4\0"+
    "\1\30\27\0\1\30\5\0\15\30\1\207\10\30\4\0"+
    "\1\30\52\0\1\210\44\0\1\30\5\0\23\30\1\211"+
    "\2\30\4\0\1\30\27\0\1\30\5\0\10\30\1\212"+
    "\15\30\4\0\1\30\3\0\1\213\23\0\1\30\5\0"+
    "\4\30\1\214\21\30\4\0\1\30\27\0\1\30\5\0"+
    "\13\30\1\215\12\30\4\0\1\30\50\0\1\216\64\0"+
    "\1\213\25\0\1\213\23\0\1\30\5\0\12\30\1\217"+
    "\13\30\4\0\1\30\5\0\1\220\21\0\1\30\5\0"+
    "\22\30\1\221\3\30\4\0\1\30\27\0\1\30\5\0"+
    "\10\30\1\222\15\30\4\0\1\30\3\0\1\223\53\0"+
    "\1\224\37\0\1\30\5\0\13\30\1\225\12\30\4\0"+
    "\1\30\27\0\1\30\5\0\4\30\1\226\21\30\4\0"+
    "\1\30\41\0\1\227\55\0\1\30\5\0\7\30\1\230"+
    "\16\30\4\0\1\30\27\0\1\30\5\0\22\30\1\231"+
    "\3\30\4\0\1\30\57\0\1\232\37\0\1\30\5\0"+
    "\20\30\1\233\5\30\4\0\1\30\27\0\1\30\5\0"+
    "\15\30\1\234\10\30\4\0\1\30\52\0\1\235\44\0"+
    "\1\30\5\0\4\30\1\236\21\30\4\0\1\30\41\0"+
    "\1\237\55\0\1\30\5\0\15\30\1\240\10\30\4\0"+
    "\1\30\52\0\1\241\44\0\1\30\5\0\4\30\1\242"+
    "\21\30\4\0\1\30\27\0\1\30\5\0\13\30\1\243"+
    "\12\30\4\0\1\30\50\0\1\244\46\0\1\30\5\0"+
    "\15\30\1\245\10\30\4\0\1\30\27\0\1\30\5\0"+
    "\6\30\1\246\17\30\4\0\1\30\43\0\1\247\53\0"+
    "\1\30\5\0\23\30\1\250\2\30\4\0\1\30\60\0"+
    "\1\251\36\0\1\30\5\0\15\30\1\252\10\30\4\0"+
    "\1\30\52\0\1\253\44\0\1\30\5\0\4\30\1\254"+
    "\21\30\4\0\1\30\41\0\1\255\34\0";

  private static int [] zzUnpacktrans() {
    int [] result = new int[5712];
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
    "\3\0\2\11\1\1\2\11\1\1\3\11\2\1\1\11"+
    "\4\1\1\11\21\1\5\11\1\1\1\11\2\1\2\11"+
    "\1\0\2\11\1\0\5\11\1\0\1\1\1\0\5\11"+
    "\21\1\2\11\2\0\14\11\1\0\7\1\1\0\5\1"+
    "\1\0\5\1\1\0\1\11\1\0\1\11\5\1\1\0"+
    "\2\1\1\11\1\1\1\0\2\1\1\0\2\1\1\0"+
    "\2\1\1\0\1\1\1\11\2\1\1\0\1\11\2\1"+
    "\1\11\2\1\1\0\2\1\1\0\1\1\1\11\1\1"+
    "\1\0\2\1\1\0\2\1\1\11\1\1\1\0\1\1"+
    "\1\11\1\1\1\11";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[173];
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
  private long yychar;

  /** Whether the scanner is currently at the beginning of a line. */
  @SuppressWarnings("unused")
  private boolean zzAtBOL = true;

  /** Whether the user-EOF-code has already been executed. */
  private boolean zzEOFDone;

  /* user code: */
    //public LinkedList<Errores> listaErrores = new LinkedList<>();
    String cadena = "";


  /**
   * Creates a new scanner
   *
   * @param   in  the java.io.Reader to read input from.
   */
  public Lexer(java.io.Reader in) {
      yyline = 1;
    yycolumn = 1;
    //listaErrores = new LinkedList<>();
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

      yychar+= zzMarkedPosL-zzStartRead;

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
          { return new java_cup.runtime.Symbol(sym.EOF); }
      }
      else {
        switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
          case 1:
            { InterfasGrafica.FrameInicio.lista.add(new Errores("LEXICO","El caracter "+yytext()+" NO pertenece al lenguaje", yyline, yycolumn));
                    System.out.println("Error Lexico: " + yytext() + " | Fila:" + yyline + " | Columna: " + yycolumn);
            }
          // fall through
          case 75: break;
          case 2:
            { /* Espacios en blanco se ignoran */
            }
          // fall through
          case 76: break;
          case 3:
            { return new Symbol(sym.NOT, yyline,yycolumn, yytext());
            }
          // fall through
          case 77: break;
          case 4:
            { cadena = ""; yybegin(CADENA);
            }
          // fall through
          case 78: break;
          case 5:
            { return new Symbol(sym.MODULO,  yyline,yycolumn, yytext());
            }
          // fall through
          case 79: break;
          case 6:
            { cadena = ""; yybegin(CARACTER);
            }
          // fall through
          case 80: break;
          case 7:
            { return new Symbol(sym.PARENTESIS_A, yyline, yycolumn, yytext());
            }
          // fall through
          case 81: break;
          case 8:
            { return new Symbol(sym.PARENTESIS_C, yyline, yycolumn, yytext());
            }
          // fall through
          case 82: break;
          case 9:
            { return new Symbol(sym.POR, yyline,yycolumn, yytext());
            }
          // fall through
          case 83: break;
          case 10:
            { return new Symbol(sym.MAS,  yyline,yycolumn, yytext());
            }
          // fall through
          case 84: break;
          case 11:
            { return new Symbol(sym.COMA, yyline, yycolumn, yytext());
            }
          // fall through
          case 85: break;
          case 12:
            { return new Symbol(sym.MENOS, yyline,yycolumn, yytext());
            }
          // fall through
          case 86: break;
          case 13:
            { return new Symbol(sym.DIV, yyline,yycolumn, yytext());
            }
          // fall through
          case 87: break;
          case 14:
            { return new Symbol(sym.ENTERO, yyline, yycolumn, yytext());
            }
          // fall through
          case 88: break;
          case 15:
            { return new Symbol(sym.DOSPUNTOS, yyline, yycolumn, yytext());
            }
          // fall through
          case 89: break;
          case 16:
            { return new Symbol(sym.PUNTOYCOMA, yyline, yycolumn, yytext());
            }
          // fall through
          case 90: break;
          case 17:
            { return new Symbol(sym.MENOR, yyline, yycolumn, yytext());
            }
          // fall through
          case 91: break;
          case 18:
            { return new Symbol(sym.IGUAL, yyline,yycolumn, yytext());
            }
          // fall through
          case 92: break;
          case 19:
            { return new Symbol(sym.MAYOR, yyline, yycolumn, yytext());
            }
          // fall through
          case 93: break;
          case 20:
            { return new Symbol(sym.ID,  yyline, yycolumn, yytext());
            }
          // fall through
          case 94: break;
          case 21:
            { return new Symbol(sym.CORCHETE_A,  yyline,yycolumn, yytext());
            }
          // fall through
          case 95: break;
          case 22:
            { return new Symbol(sym.CORCHETE_C,  yyline,yycolumn, yytext());
            }
          // fall through
          case 96: break;
          case 23:
            { return new Symbol(sym.XOR, yyline, yycolumn,yytext());
            }
          // fall through
          case 97: break;
          case 24:
            { return new Symbol(sym.BAJO, yyline,yycolumn, yytext());
            }
          // fall through
          case 98: break;
          case 25:
            { return new Symbol(sym.LLAVE_A,  yyline,yycolumn, yytext());
            }
          // fall through
          case 99: break;
          case 26:
            { return new Symbol(sym.LLAVE_C, yyline,yycolumn, yytext());
            }
          // fall through
          case 100: break;
          case 27:
            { cadena += yytext();
            }
          // fall through
          case 101: break;
          case 28:
            { String tmp = cadena; cadena = ""; yybegin(YYINITIAL); return new Symbol(sym.CADENA, yyline, yycolumn, tmp);
            }
          // fall through
          case 102: break;
          case 29:
            { cadena = yytext();
            }
          // fall through
          case 103: break;
          case 30:
            { String tmp = cadena; cadena = ""; yybegin(YYINITIAL); return new Symbol(sym.CARACTER, yyline, yycolumn, tmp);
            }
          // fall through
          case 104: break;
          case 31:
            { return new Symbol(sym.DIFERENCIA, yyline, yycolumn, yytext());
            }
          // fall through
          case 105: break;
          case 32:
            { return new Symbol(sym.AND, yyline,yycolumn, yytext());
            }
          // fall through
          case 106: break;
          case 33:
            { return new Symbol(sym.POTENCIA,  yyline,yycolumn, yytext());
            }
          // fall through
          case 107: break;
          case 34:
            { return new Symbol(sym.DOBLEMAS,  yyline,yycolumn, yytext());
            }
          // fall through
          case 108: break;
          case 35:
            { return new Symbol(sym.DOBLEMENOS, yyline,yycolumn, yytext());
            }
          // fall through
          case 109: break;
          case 36:
            { 
            }
          // fall through
          case 110: break;
          case 37:
            { return new Symbol(sym.DOBLEDOSPUNTOS, yyline, yycolumn, yytext());
            }
          // fall through
          case 111: break;
          case 38:
            { return new Symbol(sym.MENORIGUAL, yyline, yycolumn, yytext());
            }
          // fall through
          case 112: break;
          case 39:
            { return new Symbol(sym.DOBLEIGUAL, yyline, yycolumn, yytext());
            }
          // fall through
          case 113: break;
          case 40:
            { return new Symbol(sym.DATOSMATCH, yyline,yycolumn, yytext());
            }
          // fall through
          case 114: break;
          case 41:
            { return new Symbol(sym.MAYORIGUAL, yyline, yycolumn, yytext());
            }
          // fall through
          case 115: break;
          case 42:
            { return new Symbol(sym.DO, yyline, yycolumn,yytext());
            }
          // fall through
          case 116: break;
          case 43:
            { return new Symbol(sym.IF, yyline, yycolumn,yytext());
            }
          // fall through
          case 117: break;
          case 44:
            { return new Symbol(sym.OR, yyline, yycolumn,yytext());
            }
          // fall through
          case 118: break;
          case 45:
            { cadena += "\"";
            }
          // fall through
          case 119: break;
          case 46:
            { cadena += "\'";
            }
          // fall through
          case 120: break;
          case 47:
            { cadena += "\n";
            }
          // fall through
          case 121: break;
          case 48:
            { cadena += "\r";
            }
          // fall through
          case 122: break;
          case 49:
            { cadena += "\t";
            }
          // fall through
          case 123: break;
          case 50:
            { cadena += "\\";
            }
          // fall through
          case 124: break;
          case 51:
            { cadena = "\"";
            }
          // fall through
          case 125: break;
          case 52:
            { cadena = "\'";
            }
          // fall through
          case 126: break;
          case 53:
            { cadena = "\n";
            }
          // fall through
          case 127: break;
          case 54:
            { cadena = "\r";
            }
          // fall through
          case 128: break;
          case 55:
            { cadena = "\t";
            }
          // fall through
          case 129: break;
          case 56:
            { cadena = "\\";
            }
          // fall through
          case 130: break;
          case 57:
            { return new Symbol(sym.NUMERODECIMAL,  yyline,yycolumn, yytext());
            }
          // fall through
          case 131: break;
          case 58:
            { return new Symbol(sym.FOR, yyline, yycolumn,yytext());
            }
          // fall through
          case 132: break;
          case 59:
            { return new Symbol(sym.INT, yyline,yycolumn, yytext());
            }
          // fall through
          case 133: break;
          case 60:
            { return new Symbol(sym.VAR, yyline,yycolumn, yytext());
            }
          // fall through
          case 134: break;
          case 61:
            { return new Symbol(sym.BOOL, yyline,yycolumn, yytext());
            }
          // fall through
          case 135: break;
          case 62:
            { return new Symbol(sym.CHAR, yyline, yycolumn,yytext());
            }
          // fall through
          case 136: break;
          case 63:
            { return new Symbol(sym.ELSE, yyline, yycolumn,yytext());
            }
          // fall through
          case 137: break;
          case 64:
            { return new Symbol(sym.TRUE, yyline,yycolumn, yytext());
            }
          // fall through
          case 138: break;
          case 65:
            { return new Symbol(sym.BREAK, yyline, yycolumn,yytext());
            }
          // fall through
          case 139: break;
          case 66:
            { return new Symbol(sym.CONST, yyline,yycolumn, yytext());
            }
          // fall through
          case 140: break;
          case 67:
            { return new Symbol(sym.FALSE, yyline,yycolumn, yytext());
            }
          // fall through
          case 141: break;
          case 68:
            { return new Symbol(sym.MATCH, yyline, yycolumn,yytext());
            }
          // fall through
          case 142: break;
          case 69:
            { return new Symbol(sym.WHILE, yyline, yycolumn,yytext());
            }
          // fall through
          case 143: break;
          case 70:
            { return new Symbol(sym.DOUBLE, yyline,yycolumn, yytext());
            }
          // fall through
          case 144: break;
          case 71:
            { return new Symbol(sym.RETURN, yyline, yycolumn,yytext());
            }
          // fall through
          case 145: break;
          case 72:
            { return new Symbol(sym.STRING, yyline, yycolumn,yytext());
            }
          // fall through
          case 146: break;
          case 73:
            { return new Symbol(sym.PRINTLN, yyline, yycolumn, yytext());
            }
          // fall through
          case 147: break;
          case 74:
            { return new Symbol(sym.CONTINUE, yyline, yycolumn,yytext());
            }
          // fall through
          case 148: break;
          default:
            zzScanError(ZZ_NO_MATCH);
        }
      }
    }
  }


}
