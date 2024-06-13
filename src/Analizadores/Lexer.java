// DO NOT EDIT
// Generated by JFlex 1.9.1 http://jflex.de/
// source: src/Analizadores/Lexer.jflex

// ------------  Paquete e importaciones ------------
package Analizadores; 

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
    "\1\0\1\u0100\36\u0200\1\u0300\267\u0200\10\u0400\u1020\u0200";

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
    "\1\33\1\34\1\35\1\36\1\37\2\40\1\41\1\40"+
    "\1\42\1\43\1\44\1\40\1\45\1\46\1\47\1\50"+
    "\1\51\4\40\1\52\1\53\1\54\1\55\1\56\1\0"+
    "\1\27\1\30\1\31\1\32\1\33\1\34\1\35\1\36"+
    "\1\37\2\40\1\41\1\40\1\42\1\43\1\44\1\40"+
    "\1\45\1\46\1\47\1\50\1\51\4\40\1\57\1\60"+
    "\1\61\7\0\1\3\252\0\2\62\115\0\1\63\u01a8\0"+
    "\2\3\326\0\u0100\3";

  private static int [] zzUnpackcmap_blocks() {
    int [] result = new int[1280];
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
    "\1\17\1\20\1\21\1\22\1\23\12\24\1\25\1\26"+
    "\1\27\1\30\1\1\1\31\2\1\1\32\1\33\1\0"+
    "\1\34\1\35\1\0\1\36\1\37\1\40\1\41\1\42"+
    "\1\0\1\43\1\0\1\44\1\45\1\46\1\47\12\24"+
    "\1\50\2\0\1\51\1\52\1\53\1\54\1\55\1\56"+
    "\1\57\1\60\1\61\1\62\1\63\1\64\1\0\1\65"+
    "\5\24\1\66\1\24\1\0\2\24\1\67\1\66\1\0"+
    "\1\43\1\70\1\71\1\24\1\0\2\24\1\0\1\24"+
    "\1\0\1\24\1\0\1\72\2\73\1\24\2\74\1\24"+
    "\1\0\1\24\1\0\1\75\1\24\1\0\2\76\2\77";

  private static int [] zzUnpackAction() {
    int [] result = new int[128];
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
    "\0\0\0\64\0\150\0\234\0\234\0\320\0\234\0\234"+
    "\0\u0104\0\234\0\234\0\234\0\u0138\0\u016c\0\234\0\u01a0"+
    "\0\u01d4\0\u0208\0\u023c\0\234\0\u0270\0\u02a4\0\u02d8\0\u030c"+
    "\0\u0340\0\u0374\0\u03a8\0\u03dc\0\u0410\0\u0444\0\u0478\0\u04ac"+
    "\0\u04e0\0\234\0\234\0\234\0\234\0\u0514\0\234\0\u0548"+
    "\0\u057c\0\234\0\234\0\u05b0\0\234\0\234\0\u05e4\0\234"+
    "\0\234\0\234\0\234\0\234\0\u0618\0\u064c\0\u0680\0\234"+
    "\0\234\0\234\0\234\0\u06b4\0\u06e8\0\u071c\0\u0750\0\u0784"+
    "\0\u07b8\0\u07ec\0\u0820\0\u0854\0\u0888\0\234\0\u08bc\0\u08f0"+
    "\0\234\0\234\0\234\0\234\0\234\0\234\0\234\0\234"+
    "\0\234\0\234\0\234\0\234\0\u0924\0\u0680\0\u0958\0\u098c"+
    "\0\u09c0\0\u09f4\0\u0a28\0\u030c\0\u0a5c\0\u0a90\0\u0ac4\0\u0af8"+
    "\0\u030c\0\234\0\u0b2c\0\234\0\u030c\0\u030c\0\u0b60\0\u0b94"+
    "\0\u0bc8\0\u0bfc\0\u0c30\0\u0c64\0\u0c98\0\u0ccc\0\u0d00\0\u030c"+
    "\0\u030c\0\234\0\u0d34\0\u030c\0\234\0\u0d68\0\u0d9c\0\u0dd0"+
    "\0\u0e04\0\u030c\0\u0e38\0\u0e6c\0\u030c\0\234\0\u030c\0\234";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[128];
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
    "\1\32\1\33\1\30\1\34\2\30\1\35\4\30\1\36"+
    "\1\30\1\37\1\40\1\30\1\41\1\42\1\4\1\43"+
    "\1\44\1\4\1\45\1\46\1\47\1\50\1\51\5\52"+
    "\1\53\45\52\1\54\10\52\10\55\1\56\42\55\1\57"+
    "\10\55\111\0\1\60\45\0\1\61\67\0\1\62\64\0"+
    "\1\63\65\0\1\64\60\0\1\65\4\0\1\66\62\0"+
    "\1\67\1\0\1\22\64\0\1\70\66\0\1\71\63\0"+
    "\1\72\63\0\1\73\57\0\1\30\5\0\23\30\4\0"+
    "\1\30\26\0\1\30\5\0\14\30\1\74\6\30\4\0"+
    "\1\30\26\0\1\30\5\0\7\30\1\75\4\30\1\76"+
    "\6\30\4\0\1\30\26\0\1\30\5\0\14\30\1\77"+
    "\6\30\4\0\1\30\26\0\1\30\5\0\1\100\22\30"+
    "\4\0\1\30\26\0\1\30\5\0\13\30\1\101\7\30"+
    "\4\0\1\30\26\0\1\30\5\0\16\30\1\102\4\30"+
    "\4\0\1\30\26\0\1\30\5\0\20\30\1\103\2\30"+
    "\4\0\1\30\26\0\1\30\5\0\16\30\1\104\4\30"+
    "\4\0\1\30\26\0\1\30\5\0\1\105\22\30\4\0"+
    "\1\30\65\0\1\106\45\0\1\107\70\0\1\110\21\0"+
    "\1\111\2\0\1\112\31\0\1\113\2\0\1\114\1\0"+
    "\1\115\3\0\1\116\15\0\1\117\2\0\1\120\31\0"+
    "\1\121\2\0\1\122\1\0\1\123\3\0\1\124\10\0"+
    "\13\65\1\125\50\65\2\66\2\0\60\66\21\0\1\126"+
    "\63\0\1\30\5\0\14\30\1\127\6\30\4\0\1\30"+
    "\26\0\1\30\5\0\1\130\22\30\4\0\1\30\26\0"+
    "\1\30\5\0\13\30\1\131\7\30\4\0\1\30\26\0"+
    "\1\30\5\0\21\30\1\132\1\30\4\0\1\30\26\0"+
    "\1\30\5\0\12\30\1\133\10\30\4\0\1\30\26\0"+
    "\1\30\5\0\20\30\1\134\2\30\4\0\1\30\26\0"+
    "\1\30\5\0\10\30\1\135\12\30\4\0\1\30\3\0"+
    "\1\136\22\0\1\30\5\0\16\30\1\137\4\30\4\0"+
    "\1\30\26\0\1\30\5\0\21\30\1\140\1\30\4\0"+
    "\1\30\26\0\1\30\5\0\16\30\1\141\4\30\4\0"+
    "\1\30\54\0\1\142\61\0\1\143\16\0\13\65\1\125"+
    "\4\65\1\144\43\65\21\0\1\30\5\0\12\30\1\145"+
    "\10\30\4\0\1\30\26\0\1\30\5\0\16\30\1\146"+
    "\4\30\4\0\1\30\26\0\1\30\5\0\17\30\1\147"+
    "\3\30\4\0\1\30\4\0\1\150\21\0\1\30\5\0"+
    "\1\30\1\151\21\30\4\0\1\30\26\0\1\30\5\0"+
    "\17\30\1\152\3\30\4\0\1\30\4\0\1\153\21\0"+
    "\1\30\5\0\13\30\1\154\7\30\4\0\1\30\47\0"+
    "\1\155\42\0\1\30\5\0\10\30\1\156\12\30\4\0"+
    "\1\30\3\0\1\157\22\0\1\30\5\0\4\30\1\160"+
    "\16\30\4\0\1\30\44\0\1\157\22\0\1\157\22\0"+
    "\1\30\5\0\20\30\1\161\2\30\4\0\1\30\54\0"+
    "\1\162\35\0\1\30\5\0\12\30\1\163\10\30\4\0"+
    "\1\30\26\0\1\30\5\0\4\30\1\164\16\30\4\0"+
    "\1\30\40\0\1\165\51\0\1\30\5\0\20\30\1\166"+
    "\2\30\4\0\1\30\54\0\1\167\35\0\1\30\5\0"+
    "\13\30\1\170\7\30\4\0\1\30\47\0\1\171\42\0"+
    "\1\30\5\0\4\30\1\172\16\30\4\0\1\30\26\0"+
    "\1\30\5\0\12\30\1\173\10\30\4\0\1\30\46\0"+
    "\1\174\43\0\1\30\5\0\6\30\1\175\14\30\4\0"+
    "\1\30\42\0\1\176\47\0\1\30\5\0\13\30\1\177"+
    "\7\30\4\0\1\30\47\0\1\200\21\0";

  private static int [] zzUnpacktrans() {
    int [] result = new int[3744];
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
    "\4\1\1\11\15\1\4\11\1\1\1\11\2\1\2\11"+
    "\1\0\2\11\1\0\5\11\1\0\1\1\1\0\4\11"+
    "\12\1\1\11\2\0\14\11\1\0\10\1\1\0\3\1"+
    "\1\11\1\0\1\11\3\1\1\0\2\1\1\0\1\1"+
    "\1\0\1\1\1\0\2\1\1\11\2\1\1\11\1\1"+
    "\1\0\1\1\1\0\2\1\1\0\1\1\1\11\1\1"+
    "\1\11";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[128];
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
    public LinkedList<Errores> listaErrores = new LinkedList<>();
    String cadena = "";


  /**
   * Creates a new scanner
   *
   * @param   in  the java.io.Reader to read input from.
   */
  public Lexer(java.io.Reader in) {
      yyline = 1;
    yycolumn = 1;
    listaErrores = new LinkedList<>();
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
            { listaErrores.add(new Errores("LEXICO","El caracter "+yytext()+" NO pertenece al lenguaje", yyline, yycolumn));
                    System.out.println("Error Lexico: " + yytext() + " | Fila:" + yyline + " | Columna: " + yycolumn);
            }
          // fall through
          case 64: break;
          case 2:
            { /* Espacios en blanco se ignoran */
            }
          // fall through
          case 65: break;
          case 3:
            { return new Symbol(sym.NOT, yyline,yycolumn, yytext());
            }
          // fall through
          case 66: break;
          case 4:
            { cadena = ""; yybegin(CADENA);
            }
          // fall through
          case 67: break;
          case 5:
            { return new Symbol(sym.MODULO,  yyline,yycolumn, yytext());
            }
          // fall through
          case 68: break;
          case 6:
            { cadena = ""; yybegin(CARACTER);
            }
          // fall through
          case 69: break;
          case 7:
            { return new Symbol(sym.PARENTESIS_A, yyline, yycolumn, yytext());
            }
          // fall through
          case 70: break;
          case 8:
            { return new Symbol(sym.PARENTESIS_C, yyline, yycolumn, yytext());
            }
          // fall through
          case 71: break;
          case 9:
            { return new Symbol(sym.POR, yyline,yycolumn, yytext());
            }
          // fall through
          case 72: break;
          case 10:
            { return new Symbol(sym.MAS,  yyline,yycolumn, yytext());
            }
          // fall through
          case 73: break;
          case 11:
            { return new Symbol(sym.COMA, yyline, yycolumn, yytext());
            }
          // fall through
          case 74: break;
          case 12:
            { return new Symbol(sym.MENOS, yyline,yycolumn, yytext());
            }
          // fall through
          case 75: break;
          case 13:
            { return new Symbol(sym.DIV, yyline,yycolumn, yytext());
            }
          // fall through
          case 76: break;
          case 14:
            { return new Symbol(sym.ENTERO, yyline, yycolumn, yytext());
            }
          // fall through
          case 77: break;
          case 15:
            { return new Symbol(sym.DOSPUNTOS, yyline, yycolumn, yytext());
            }
          // fall through
          case 78: break;
          case 16:
            { return new Symbol(sym.PUNTOYCOMA, yyline, yycolumn, yytext());
            }
          // fall through
          case 79: break;
          case 17:
            { return new Symbol(sym.MENOR, yyline, yycolumn, yytext());
            }
          // fall through
          case 80: break;
          case 18:
            { return new Symbol(sym.IGUAL, yyline,yycolumn, yytext());
            }
          // fall through
          case 81: break;
          case 19:
            { return new Symbol(sym.MAYOR, yyline, yycolumn, yytext());
            }
          // fall through
          case 82: break;
          case 20:
            { return new Symbol(sym.ID,  yyline, yycolumn, yytext());
            }
          // fall through
          case 83: break;
          case 21:
            { return new Symbol(sym.CORCHETE_A,  yyline,yycolumn, yytext());
            }
          // fall through
          case 84: break;
          case 22:
            { return new Symbol(sym.CORCHETE_C,  yyline,yycolumn, yytext());
            }
          // fall through
          case 85: break;
          case 23:
            { return new Symbol(sym.XOR, yyline, yycolumn,yytext());
            }
          // fall through
          case 86: break;
          case 24:
            { return new Symbol(sym.LLAVE_A,  yyline,yycolumn, yytext());
            }
          // fall through
          case 87: break;
          case 25:
            { return new Symbol(sym.LLAVE_C, yyline,yycolumn, yytext());
            }
          // fall through
          case 88: break;
          case 26:
            { cadena += yytext();
            }
          // fall through
          case 89: break;
          case 27:
            { String tmp = cadena; cadena = ""; yybegin(YYINITIAL); return new Symbol(sym.CADENA, yyline, yycolumn, tmp);
            }
          // fall through
          case 90: break;
          case 28:
            { cadena = yytext();
            }
          // fall through
          case 91: break;
          case 29:
            { String tmp = cadena; cadena = ""; yybegin(YYINITIAL); return new Symbol(sym.CARACTER, yyline, yycolumn, tmp);
            }
          // fall through
          case 92: break;
          case 30:
            { return new Symbol(sym.DIFERENCIA, yyline, yycolumn, yytext());
            }
          // fall through
          case 93: break;
          case 31:
            { return new Symbol(sym.AND, yyline,yycolumn, yytext());
            }
          // fall through
          case 94: break;
          case 32:
            { return new Symbol(sym.POTENCIA,  yyline,yycolumn, yytext());
            }
          // fall through
          case 95: break;
          case 33:
            { return new Symbol(sym.DOBLEMAS,  yyline,yycolumn, yytext());
            }
          // fall through
          case 96: break;
          case 34:
            { return new Symbol(sym.DOBLEMENOS, yyline,yycolumn, yytext());
            }
          // fall through
          case 97: break;
          case 35:
            { 
            }
          // fall through
          case 98: break;
          case 36:
            { return new Symbol(sym.DOBLEDOSPUNTOS, yyline, yycolumn, yytext());
            }
          // fall through
          case 99: break;
          case 37:
            { return new Symbol(sym.MENORIGUAL, yyline, yycolumn, yytext());
            }
          // fall through
          case 100: break;
          case 38:
            { return new Symbol(sym.DOBLEIGUAL, yyline, yycolumn, yytext());
            }
          // fall through
          case 101: break;
          case 39:
            { return new Symbol(sym.MAYORIGUAL, yyline, yycolumn, yytext());
            }
          // fall through
          case 102: break;
          case 40:
            { return new Symbol(sym.OR, yyline, yycolumn,yytext());
            }
          // fall through
          case 103: break;
          case 41:
            { cadena += "\"";
            }
          // fall through
          case 104: break;
          case 42:
            { cadena += "\'";
            }
          // fall through
          case 105: break;
          case 43:
            { cadena += "\n";
            }
          // fall through
          case 106: break;
          case 44:
            { cadena += "\r";
            }
          // fall through
          case 107: break;
          case 45:
            { cadena += "\t";
            }
          // fall through
          case 108: break;
          case 46:
            { cadena += "\\";
            }
          // fall through
          case 109: break;
          case 47:
            { cadena = "\"";
            }
          // fall through
          case 110: break;
          case 48:
            { cadena = "\'";
            }
          // fall through
          case 111: break;
          case 49:
            { cadena = "\n";
            }
          // fall through
          case 112: break;
          case 50:
            { cadena = "\r";
            }
          // fall through
          case 113: break;
          case 51:
            { cadena = "\t";
            }
          // fall through
          case 114: break;
          case 52:
            { cadena = "\\";
            }
          // fall through
          case 115: break;
          case 53:
            { return new Symbol(sym.NUMERODECIMAL,  yyline,yycolumn, yytext());
            }
          // fall through
          case 116: break;
          case 54:
            { return new Symbol(sym.INT, yyline,yycolumn, yytext());
            }
          // fall through
          case 117: break;
          case 55:
            { return new Symbol(sym.VAR, yyline,yycolumn, yytext());
            }
          // fall through
          case 118: break;
          case 56:
            { return new Symbol(sym.BOOL, yyline,yycolumn, yytext());
            }
          // fall through
          case 119: break;
          case 57:
            { return new Symbol(sym.CHAR, yyline, yycolumn,yytext());
            }
          // fall through
          case 120: break;
          case 58:
            { return new Symbol(sym.TRUE, yyline,yycolumn, yytext());
            }
          // fall through
          case 121: break;
          case 59:
            { return new Symbol(sym.CONST, yyline,yycolumn, yytext());
            }
          // fall through
          case 122: break;
          case 60:
            { return new Symbol(sym.FALSE, yyline,yycolumn, yytext());
            }
          // fall through
          case 123: break;
          case 61:
            { return new Symbol(sym.DOUBLE, yyline,yycolumn, yytext());
            }
          // fall through
          case 124: break;
          case 62:
            { return new Symbol(sym.STRING, yyline, yycolumn,yytext());
            }
          // fall through
          case 125: break;
          case 63:
            { return new Symbol(sym.PRINTLN, yyline, yycolumn, yytext());
            }
          // fall through
          case 126: break;
          default:
            zzScanError(ZZ_NO_MATCH);
        }
      }
    }
  }


}
