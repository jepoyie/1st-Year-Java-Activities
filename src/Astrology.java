import javax.swing.JOptionPane;
import static java.lang.Math.abs;

public class Astrology {

    public static void main(String[] args) {

        JOptionPane.showMessageDialog(null, "Welcome to Hidalgo's Horoscope System");

        String sign;
        String name;
        int birthday;
        int birthmonth;
        int birthyear;
        int currentDay;
        int currentMonth;
        int currentYear;
        int partialMonth;
        int Months = 0;
        int Years = 0;

         name = JOptionPane.showInputDialog(null, "Enter your name: ");

        do {
            birthday = Integer.parseInt(JOptionPane.showInputDialog("Enter your day of birth: "));
        } while (birthday < 1 || birthday > 31);
        do {
            birthmonth = Integer.parseInt(JOptionPane.showInputDialog("Enter your month of birth: "));
        } while (birthmonth < 1 || birthmonth > 12);
        birthyear = Integer.parseInt(JOptionPane.showInputDialog("Enter your year of birth: "));
        do {
            currentDay = Integer.parseInt(JOptionPane.showInputDialog("Enter the current day: "));
        } while (currentDay < 1 || currentDay > 31);
        do {
            currentMonth = Integer.parseInt(JOptionPane.showInputDialog("Enter the current month: "));
        } while (currentMonth < 1 || currentMonth > 12);
        currentYear = Integer.parseInt(JOptionPane.showInputDialog("Enter the current year: "));

            if (birthmonth > 12 && birthmonth > 0) {
                System.out.println("Invalid day of birth!");
                System.exit(0);
            } else if (birthmonth == currentMonth){
                if (birthday > currentDay){
                    partialMonth = currentMonth - birthmonth;
                    Months = 12 - 1;
                    Years = (currentYear - birthyear) - 1;

                } else {
                    Months = currentMonth - birthmonth;
                    Years = currentYear - birthyear;
                }

            } else if (birthmonth < currentMonth){
                if (birthday == currentDay){
                    Months = currentMonth - birthmonth;
                    Years = currentYear - birthyear;

                } else if (birthday > currentDay){
                    partialMonth = currentMonth - birthmonth;
                    Months = partialMonth - 1;
                    Years = currentYear - birthyear;

                }  else {
                    Months = currentMonth - birthmonth;
                    Years = currentYear - birthyear;
                }

            } else if (birthday > currentDay){
                partialMonth = currentMonth - birthmonth;
                Months = 11 - 1;
                Years = (currentYear - birthyear) - 1;

            } else {
                partialMonth = currentMonth - birthmonth;
                Months = 12 - abs (partialMonth);
                Years = (currentYear - birthyear) - 1;
            }

        if (birthmonth == 1 && birthday > 19 || birthmonth == 2 && birthday < 19){
            JOptionPane.showMessageDialog(null, "Hi " + name + ", your zodiac sign is AQUARIUS. Aquarius is a quirky sign. It is ruled by the planet Uranus, the only planet that spins onr its side, so Aquaius tends to march to the beat of its own drum. You are now " + Years + " years and " + Months + " month/s old.");
        } else if (birthmonth == 2 && birthday > 18 || birthmonth == 3 && birthday < 21){
            JOptionPane.showMessageDialog(null,"Hi " + name + ", your zodiac sign is PISCES. Pisces tend to be loners, they are soulful and likely to be empath, easily taking on other people’s emotions. You are now " + Years + " years and " + Months + " month/s old.");
        } else if (birthmonth == 3 & birthday > 20 || birthmonth == 4 && birthday < 20){
            JOptionPane.showMessageDialog(null,"Hi " + name + ", your zodiac sign is ARIES. Aries loves to be number one. Naturally, the dynamic fire sign is no stranger to competition. Bold and ambitious, Aries dives headfirst into even the most challenging situations—and they will make sure they always come out on top! You are now " + Years + " years and " + Months + " month/s old.");
        }else if (birthmonth == 4 && birthday > 19 || birthmonth == 5 && birthday < 21){
            JOptionPane.showMessageDialog(null,"Hi " + name + ", your zodiac sign is TAURUS. Taurus is an earth sign represented by the bull. Like their celestial spirit animal, Taureans enjoy relaxing in serene, bucolic environments surrounded by soft sounds, soothing aromas, and succulent flavors. You are now " + Years + " years and " + Months + " month/s old.");
        }else if (birthmonth == 5 && birthday > 20 || birthmonth == 6 && birthday < 21){
            JOptionPane.showMessageDialog(null,"Hi " + name + ", your zodiac sign is GEMINI. Spontaneous, playful, and adorably erratic, Gemini is driven by its insatiable curiosity. Appropriately symbolized by the celestial twins, this air sign was interested in so many pursuits that it had to double itself. You are now " + Years + " years and " + Months + " month/s old.");
        }else if (birthmonth == 6 && birthday > 20 || birthmonth == 7 && birthday < 23){
            JOptionPane.showMessageDialog(null,"Hi " + name + ", your zodiac sign is CANCER. Cancer seamlessly weaves between the sea and shore representing Cancer’s ability to exist in both emotional and material realms. Cancers are highly intuitive and their psychic abilities manifest in tangible spaces. You are now " + Years + " years and " + Months + " month/s old.");
        }else if (birthmonth == 7 && birthday > 22 || birthmonth == 8 && birthday < 23){
            JOptionPane.showMessageDialog(null,"Hi " + name + ", your zodiac sign is LEO. Leos are passionate and creative. They are natural leaders who love to put on a show. With all that passion and fierceness at the forefront, it may be surprising to learn that underneath all that, Leos have a huge heart. You are now " + Years + " years and " + Months + " month/s old.");
        }else if (birthmonth == 8 && birthday > 22 || birthmonth == 9 && birthday < 23){
            JOptionPane.showMessageDialog(null,"Hi " + name + ", your zodiac sign is VIRGO. Virgos are analytical (sometimes a little too analytical). They are dedicated, resourceful, and hardworking. You are now " + Years + " years and " + Months + " month/s old.");
        }else if (birthmonth == 9 && birthday > 22 || birthmonth == 10 && birthday < 23){
            JOptionPane.showMessageDialog(null,"Hi " + name + ", your zodiac sign is LIBRA. Libra have expensive taste. They are the trendsetters and generally the ones to get a party started. You are now " + Years + " years and " + Months + " month/s old.");
        }else if (birthmonth == 10 && birthday > 22 || birthmonth == 11 && birthday < 22){
            JOptionPane.showMessageDialog(null,"Hi " + name + ", your zodiac sign is SCORPIO. Scorpios are by far the most passionate of the signs. They also tend to be secretive and shadowy. You are now " + Years + " years and " + Months + " month/s old.");
        }else if (birthmonth == 11 && birthday > 21 || birthmonth == 12 && birthday < 22){
            JOptionPane.showMessageDialog(null,"Hi " + name + ", your zodiac sign is SAGUITTARIUS. Sagittarius is a free spirit who is happiest in open spaces with plenty of adventure. They tend to be optimistic and open-minded. You are now " + Years + " years and " + Months + " month/s old.");
        }else if (birthmonth == 12 && birthday > 21 || birthmonth == 1 && birthday < 20){
            JOptionPane.showMessageDialog(null,"Hi " + name + ", your zodiac sign is CAPRICORN. Capricorns are loyal, family-minded, and hardworking. Capricorns like the simplest and straightest route when making a plan. You are now " + Years + " years and " + Months + " month/s old.");
        }
    }
}
