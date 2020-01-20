package jp.ac.uryukyu.ie.e195755;

/**
 * HTTPメソッドを提供します。
 * 現在はGETとPOSTしか抽象化されていません。
 */
interface HTTPMethod {
    void get();  //将来
    void post(); //将来
}
