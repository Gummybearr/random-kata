pub fn run(){
  let x = 1;
  let y = 2.5;
  println!("Max i32: {}", std::i32::MAX);
  println!("Max i32: {}", std::i64::MAX);

  let is_active = true;
  let is_greater = 10 > 5;
  let a1 = 'a';
  let a2 = '\u{1F600}';
  println!("{:?}", (x, y, is_active, is_greater, a1, a2));

}