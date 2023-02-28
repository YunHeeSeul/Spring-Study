package hello.hellospring.controller;

public class MemberForm {
    private String name;    //createMemberForm.html의 name과 매칭이 되면서 값이 들어올 것

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
