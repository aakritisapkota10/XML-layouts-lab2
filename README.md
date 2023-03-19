# XML-layouts-lab2

The project utilized XML to define the app's layout and implemented several user interface elements such as EditText, RadioButtons, RadioGroup, and Switch.
The EditText field allowed the user to input or edit text with a helpful hint to guide them on what is expected in that field. To limit the type of text that can be 
inputted, we specified the android:inputType attribute. The RadioGroup allows to create a list of exclusive options and pre-select an option for the user. Also,
added a label to the Switch, without using a separate TextView, to give more context to the user. To ensure a responsive layout, we have added vertical and horizontal 
constraints to each child View of the ConstraintLayout. Additionally, used "start" and "end" constraints to handle both LTR and RTL languages. Finally, to make a View as wide as the ConstraintLayout, constrained the start and end to the parent's start and end and set the width to 0dp. 
