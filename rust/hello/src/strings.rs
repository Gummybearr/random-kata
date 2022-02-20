pub fn run(){
  let hello = String::from("Hello");

  println!("{:?}", (hello.len(), hello));
  // println!("{:?}", (hello, hello.len()));
}