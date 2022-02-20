// Variables hold primitive data or references to data
// Variables are immutable by default
// Rust is a block-scoped language

pub fn run() {
  let name = "Brad";
  let age = 37; 

  println!("My name is {} and I am {}", name, age);

  const ID: i32 = 001;
  println!("ID: {}", ID);

  let ( my_name, my_age ) = ("Brad", 37);
  println!("{} is {}", my_name, my_age);
}