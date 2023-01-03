package testng;

public class RandomUser {
    public String gender;
    public String email;
    public String phone;
    public String cell;
    public String nat;
    public Name name;
    public Location location;
    public Login login;
    public Dob dob;
    public Registered registered;
    public Id id;
    public Picture picture;

    public class Coordinates {
        public String latitude;
        public String longitude;
    }

    public class Dob {
        public int age;
        public String date;
    }

    public class Id {
        public Object name;
        public Object value;
    }

    public class Location {
        public Street street;
        public String city;
        public String state;
        public String country;
        public String postcode;
        public Coordinates coordinates;
        public Timezone timezone;
    }

    public class Login {
        public String uuid;
        public String username;
        public String password;
        public String salt;
        public String md5;
        public String sha1;
        public String sha256;
    }

    public class Name {
        public String title;
        public String first;
        public String last;
    }

    public class Picture {
        public String large;
        public String medium;
        public String thumbnail;
    }

    public class Registered {
        public int age;
        public String date;
    }

    public class Street {
        public String name;
        public int number;
    }

    public class Timezone {
        public String offset;
        public String description;
    }
}
