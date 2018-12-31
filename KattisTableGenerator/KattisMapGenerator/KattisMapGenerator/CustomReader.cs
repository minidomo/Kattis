using System;
using System.IO;
using System.Text;

namespace KattisMapGenerator {
    public class CustomReader {
        private BinaryReader sc;
        private char[] buffer;
        private char c;
        private int bufferPointer, charsRead;
        private const int BUFFER_SIZE = 1 << 16;
        private const char EMPTY = (char) 1,
            END_OF_STREAM = (char) 0;

        public CustomReader (string filename) {
            sc = new BinaryReader (new FileStream (filename, FileMode.Open, FileAccess.Read, FileShare.Read, BUFFER_SIZE), UnicodeEncoding.Default);
            buffer = new char[BUFFER_SIZE];
            bufferPointer = charsRead = 0;
            c = EMPTY;
        }

        public CustomReader (Stream stream) {
            sc = new BinaryReader (stream, UnicodeEncoding.Default);
            buffer = new char[BUFFER_SIZE];
            bufferPointer = charsRead = 0;
            c = EMPTY;
        }

        public string NextLine () {
            if (c == EMPTY)
                c = Read ();
            // trim front spaces
            while (c == ' ')
                c = Read ();
            if (c == END_OF_STREAM)
                return null;
            char[] arr = new char[BUFFER_SIZE];
            int i = 0;
            while (c != END_OF_STREAM && c != '\n') {
                if (c != '\r')
                    arr[i++] = c;
                c = Read ();
            }
            if (c == '\n')
                c = Read ();
            // trim back spaces
            for (int x = i - 1; x >= 0 && arr[x] == ' '; x--)
                i--;
            return new string (arr, 0, i);
        }

        public string Next () {
            if (c == EMPTY)
                c = Read ();
            // skip leading spaces, \r, \n
            while (c == ' ' || c == '\r' || c == '\n')
                c = Read ();
            if (c == END_OF_STREAM)
                return null;
            char[] arr = new char[BUFFER_SIZE];
            int i = 0;
            while (c != END_OF_STREAM && c != ' ' && c != '\n') {
                if (c != '\r')
                    arr[i++] = c;
                c = Read ();
            }
            if (c == '\n')
                c = Read ();
            return new string (arr, 0, i);
        }
        public string Next (char a, out bool endOfLine) {
            if (c == EMPTY)
                c = Read ();
            // skip leading chars, \r, \n
            while (c == a || c == '\r' || c == '\n')
                c = Read ();
            if (c == END_OF_STREAM) {
                endOfLine = true;
                return null;
            }
            char[] arr = new char[BUFFER_SIZE];
            int i = 0;
            while (c != END_OF_STREAM && c != a && c != '\n') {
                if (c != '\r')
                    arr[i++] = c;
                c = Read ();
            }
            if (c == '\n') {
                c = Read ();
                endOfLine = true;
            } else
                endOfLine = c == END_OF_STREAM;
            return new string (arr, 0, i);
        }

        private void FillBuffer () {
            buffer = sc.ReadChars (BUFFER_SIZE);
            charsRead = buffer.Length;
            bufferPointer = 0;
            if (c == EMPTY && charsRead > 0)
                if (buffer[0] == '\uFEFF')
                    bufferPointer++;
        }

        private char Read () {
            while (bufferPointer == charsRead) {
                FillBuffer ();
                if (charsRead == 0)
                    return END_OF_STREAM;
            }
            if (charsRead == 0)
                return END_OF_STREAM;
            return buffer[bufferPointer++];
        }

        public void Close () {
            if (sc != null)
                sc.Close ();
        }
    }
}