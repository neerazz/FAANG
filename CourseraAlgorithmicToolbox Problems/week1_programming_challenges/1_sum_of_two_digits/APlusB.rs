fn main() {
    let mut buff = String::new();
    ::std::io::stdin().read_line(&mut buff);
    let mut words = buff.split_whitespace();

    let a: i64 = words.next().unwrap().parse().unwrap();
    let b: i64 = words.next().unwrap().parse().unwrap();

    println!("{}", a + b);
}
